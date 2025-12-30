package com.example.navegacion.data.api.responses



import com.google.gson.annotations.SerializedName

data class ProductoResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("precio_base") val precioBase: Double,
    @SerializedName("tiene_opcion_doble") val tieneOpcionDoble: Boolean,
    @SerializedName("precio_doble") val precioDoble: Double?,
    @SerializedName("disponible") val disponible: Boolean,
    @SerializedName("categoria_id") val categoriaId: Int
)