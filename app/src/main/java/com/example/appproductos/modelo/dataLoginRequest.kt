package com.example.appproductos.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataLoginRequest(
    @SerialName("nombreUsuario") val nombreUsuario: String = "",
    @SerialName("passusuario") val passusuario: String = ""
)
