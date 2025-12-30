package com.example.navegacion.data.api.responses



import com.google.gson.annotations.SerializedName

data class CategoriaResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("descripcion") val descripcion: String?
)


