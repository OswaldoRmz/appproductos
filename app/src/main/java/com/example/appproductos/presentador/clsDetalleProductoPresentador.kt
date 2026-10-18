package com.example.appproductos.presentador

import com.example.appproductos.vista.DetalleProductoActivity
import com.example.appproductos.modelo.clsProductosMoodelos
import com.example.appproductos.modelo.dataImagenesProducto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsDetalleProductoPresentador(private val vista: DetalleProductoActivity) {
    private val modelo = clsProductosMoodelos()


    fun cargarDetalle(productoId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                // Aquí se consume obtenerDetalleProducto del modelo
                val listaImagenes: List<dataImagenesProducto> = modelo.obtenerDetalleProducto(productoId)
                vista.mostrarImagenes(listaImagenes)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar detalle: " + e.localizedMessage)
            }
        }
    }
}