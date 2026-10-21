package com.example.appproductos.interfaceApi

import com.example.appproductos.modelo.dataCategorias
import com.example.appproductos.modelo.dataImagenesProducto
import com.example.appproductos.modelo.dataLoginRequest
import com.example.appproductos.modelo.dataLoginResponse
import com.example.appproductos.modelo.dataProductos
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServicio {
    @GET(value ="obtener_categorias.php") //api en php
    suspend fun obtenerCategorias(): List<dataCategorias>

    // Aqui agreamos los EndPoints para el recyvler y para la vista detalle.
    @GET("obtener_productos.php")
    suspend fun obtenerProductos(@Query("categoria_id") categoriaId: Int): List<dataProductos>

    @GET("detalle_producto.php")
    suspend fun detalleProducto(@Query("producto_id") productoId: Int): List<dataImagenesProducto>

    @POST("login.php")
    suspend fun iniciarSesion(@Body request: dataLoginRequest): dataLoginResponse
}