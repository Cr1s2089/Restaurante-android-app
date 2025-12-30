package com.example.navegacion.repository

import com.example.navegacion.data.api.MarcarPagadoRequest
import com.example.navegacion.data.api.RetrofitClient
import com.example.navegacion.data.api.requests.EstadoUpdateInput
import com.example.navegacion.data.api.responses.DetallePedidoResponse
import com.example.navegacion.data.api.requests.PedidoInput
import com.example.navegacion.data.api.responses.PedidoResponse
import com.example.navegacion.ui.viewmodel.PedidoViewModel

import retrofit2.Response

class RodosRepository {
    private val apiService = RetrofitClient.apiService
    suspend fun createPedido(
        productos: Map<Int, PedidoViewModel.ProductoSeleccionado>,
        total: Double
        ): PedidoResponse {
        val detalles = productos.values.map {
            DetallePedidoResponse(
                producto_id = it.id,
                producto_nombre = it.nombre,
                cantidad = it.cantidad,
                precio_unitario = it.precio,
                subtotal = it.cantidad*it.precio,
            )
        }

        val pedidoInput = PedidoInput(
            detalles = detalles,
            estado = "pendiente",
            total = total
        )

        return RetrofitClient.apiService.createPedido(pedidoInput)
    }

    suspend fun updatePedidoStatus(orderId: String, newStatus: String): PedidoResponse {
        val input = EstadoUpdateInput(id = orderId, estado = newStatus)
        return apiService.updatePedidoStatus(input)
    }

    suspend fun marcarPedidoComoPagado(pedidoId: Int): Response<PedidoResponse> {
        return apiService.marcarPedidoComoPagado(MarcarPagadoRequest(id = pedidoId.toString()))
    }

    suspend fun getPedidosPagados(): List<PedidoResponse> {
        return apiService.getPedidos(estado = "completado", pagado = true)
    }

    suspend fun getPedidosPendientes() = apiService.getPedidos(estado = "pendiente")


    suspend fun getPedidosCompletadosNoPagados() = apiService.getPedidos(
        estado = "completado",
        pagado = false
    )
}
