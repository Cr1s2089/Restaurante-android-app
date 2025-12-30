package com.example.navegacion.data.api.responses

import java.io.Serializable

// CLASE ÚNICA DE RESPUESTA (Estandariza el ID como Int)
data class PedidoResponse(
    val id: Int,
    val fecha_hora: String,
    val estado: String, // "pendiente", "completado"
    val total: Double,
    val pagado: Boolean,
    val detalles: List<DetallePedidoResponse> = emptyList()
) : Serializable

// PARA CREAR PEDIDOS (Input)

data class DetallePedidoResponse(
    val producto_id: Int,
    val producto_nombre: String,
    val cantidad: Int,
    val precio_unitario: Double,
    val subtotal: Double
)

