package com.example.navegacion.data.api.requests

import com.example.navegacion.data.api.responses.DetallePedidoResponse


data class EstadoUpdateInput(
    val id: String,
    val estado: String
)
data class PedidoInput(
    val detalles: List<DetallePedidoResponse>,
    val total: Double,
    val estado: String = "pendiente"
)
