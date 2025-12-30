package com.example.navegacion.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.navegacion.data.api.responses.PedidoResponse
import com.example.navegacion.repository.RodosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class PedidoViewModel : ViewModel() {
    private val repository = RodosRepository()

    // Productos seleccionados actualmente
    private val _selectedProducts = MutableStateFlow<Map<Int, ProductoSeleccionado>>(emptyMap())
    private val _pedidosCompletados = MutableStateFlow<List<PedidoResponse>>(emptyList())
    val pedidosCompletados: StateFlow<List<PedidoResponse>> = _pedidosCompletados.asStateFlow()

    private val _pedidosPagados = MutableStateFlow<List<PedidoResponse>>(emptyList())
    val pedidosPagados: StateFlow<List<PedidoResponse>> = _pedidosPagados

    val selectedProducts: StateFlow<Map<Int, ProductoSeleccionado>> = _selectedProducts.asStateFlow()

    // Pedidos enviados (para el chef)
    private val _pedidos = MutableStateFlow<List<PedidoResponse>>(emptyList())
    val pedidos: StateFlow<List<PedidoResponse>> = _pedidos.asStateFlow()

    // Estado de carga para operaciones de API
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // Mensaje de error
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    // Carga los pedidos al iniciar (para el chef)
    init {
        fetchPedidos()
    }
    data class ProductoSeleccionado(
        val id: Int,
        val nombre: String,
        val precio: Double,
        val cantidad: Int
    )

    // Añadir un producto al pedido actual
    fun addProduct(id: Int, name: String, price: Double) {
        _selectedProducts.value = _selectedProducts.value.toMutableMap().apply {
            val current = get(id)
            if (current != null) {
                // Si ya existe, incrementa la cantidad
                put(id, current.copy(cantidad = current.cantidad + 1))
            } else {
                // Si no existe, crea un nuevo producto con cantidad 1
                put(id, ProductoSeleccionado(id, name, price, 1))
            }
        }
    }

    // Eliminar una unidad de un producto
    fun removeProduct(productId: Int) {
        val current = _selectedProducts.value[productId]
        if (current != null) {
            if (current.cantidad <= 1) {
                removeProductCompletely(productId)
            } else {
                _selectedProducts.value = _selectedProducts.value.toMutableMap().apply {
                    put(productId, current.copy(cantidad = current.cantidad - 1))
                }
            }
        }
    }
    // Eliminar completamente un producto
    fun removeProductCompletely(productId: Int) {
        _selectedProducts.value = _selectedProducts.value.toMutableMap().apply {
            remove(productId)
        }
    }

    // Limpiartodo el pedido
    fun clearOrder() {
        _selectedProducts.value = emptyMap()
    }

    // Calcular el total del pedido actual
    private fun calculateTotal(): Double {
        // Ejemplo de cálculo - adapta a tu lógica de negocio
        return _selectedProducts.value.values.sumOf { producto ->
            producto.precio * producto.cantidad
        }
    }

    // Enviar pedido a la API
    fun sendOrder() {
        viewModelScope.launch {
            if (_selectedProducts.value.isEmpty()) return@launch

            _isLoading.value = true
            _errorMessage.value = null

            try {
                val total = calculateTotal()
                val createdPedido = repository.createPedido(_selectedProducts.value, total)

                // Añadir a la lista local de pedidos y limpiar el pedido actual
                _pedidos.value = _pedidos.value + createdPedido
                clearOrder()
            } catch (e: Exception) {
                _errorMessage.value = "Error al enviar el pedido: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Cargar pedidos desde la API (para el chef)
    fun fetchPedidos() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val pedidosPendientes = repository.getPedidosPendientes()
                //val pedidosResponse = repository.getPedidosByStatus("pendiente")
                _pedidos.value = pedidosPendientes//pedidosResponse
            } catch (e: Exception) {
                _errorMessage.value = "Error al cargar pedidos: ${e.message}"
            }finally {
                _isLoading.value = false
            }
        }
    }
    fun deletePedido(pedidoId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // 1. Marcar como completado en el backend
                val updatedPedido = repository.updatePedidoStatus(pedidoId, "completado")

                // 2. Actualizar ambas listas localmente
                _pedidos.value = _pedidos.value.filter { it.id.toString() != pedidoId }

                // 3. Forzar refresco de datos desde el servidor fetchPedidos() // Vuelve a cargar solo pendientes
                fetchPedidosCompletados() // Actualiza completados

            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun fetchPedidosCompletados() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val pedidos = repository.getPedidosCompletadosNoPagados()
                _pedidosCompletados.value = pedidos
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Error al cargar pedidos: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun marcarPedidoComoPagado(pedidoId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // 1. Marcar como pagado en el backend
                repository.marcarPedidoComoPagado(pedidoId)

                // 2. Actualizar listas localmente sin necesidad de recargar todo
                _pedidosCompletados.value = _pedidosCompletados.value.filter { it.id != pedidoId }

                // 3. Opcional: Si quieres que aparezca inmediatamente en reportes
                val updatedList = _pedidosPagados.value.toMutableList()
                val pedidoPagado = _pedidosCompletados.value.find { it.id == pedidoId }
                pedidoPagado?.let { updatedList.add(it) }
                _pedidosPagados.value = updatedList

                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun fetchPedidosPagados() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val pedidos = repository.getPedidosPagados()
                _pedidosPagados.value = pedidos
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Error al cargar pedidos pagados: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }


    private val _pedidosDelMes = mutableStateOf<List<PedidoResponse>>(emptyList())
    val pedidosDelMes: State<List<PedidoResponse>> = _pedidosDelMes

    private val _mesSeleccionado = mutableStateOf("")
    val mesSeleccionado: State<String> = _mesSeleccionado

    fun setPedidosDelMes(mes: String, pedidos: Any?) {
        _mesSeleccionado.value = mes
        _pedidosDelMes.value = pedidos as List<PedidoResponse>
    }
}