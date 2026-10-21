package com.example.appproductos.modelo

class clsLoginModelo {
    suspend fun autentificarUsuario(usuario: String, clave: String): dataLoginResponse{
        val request = dataLoginRequest(nombreUsuario = usuario, passusuario = clave)
        return RetrofitCliente.apiService.iniciarSesion(request)
    }
}