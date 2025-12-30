package com.example.navegacion.data.api

import com.example.navegacion.data.api.requests.EstadoUpdateInput
import com.example.navegacion.data.api.requests.PedidoInput
import com.example.navegacion.data.api.responses.* // Importa todo lo de responses
import retrofit2.Response
import retrofit2.http.*


interface RodosApiService {

    // Endpoints de pedidos
    @POST("pedidos")
    suspend fun createPedido(@Body pedido: PedidoInput): PedidoResponse

    @PUT("pedidos")
    suspend fun updatePedidoStatus(@Body estadoUpdate: EstadoUpdateInput): PedidoResponse

    @PUT("pedidos/marcar-pagado")
    suspend fun marcarPedidoComoPagado(@Body request: MarcarPagadoRequest): Response<PedidoResponse>

    @GET("pedidos")
    suspend fun getPedidos(
        @Query("estado") estado: String? = null,
        @Query("pagado") pagado: Boolean? = null
    ): List<PedidoResponse>

}

data class MarcarPagadoRequest(
    val id: String
)

