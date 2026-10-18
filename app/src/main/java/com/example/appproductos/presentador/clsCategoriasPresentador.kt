package com.example.appproductos.presentador

import com.example.appproductos.modelo.clsCategoriasModelo
import com.example.appproductos.modelo.clsProductosMoodelos
import com.example.appproductos.modelo.dataCategorias
import com.example.appproductos.modelo.dataProductos
import com.example.appproductos.vista.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsCategoriasPresentador(private val vista: MainActivity) {
    private val modelo= clsCategoriasModelo()
    private val modeloProductos = clsProductosMoodelos()
    private var listaCategorias:List<dataCategorias> =emptyList()

    fun iniciar(){
        CoroutineScope(Dispatchers.Main).launch {
        try{
            listaCategorias=modelo.obtenerCategorias()
            vista.mostrarCategorias(listaCategorias)

            cargarProductos(0)

        }catch (e: Exception){
            vista.mostrarError("Error:"+e.localizedMessage)
        }
        }
    }

    fun seleccionarCategoria(posicion: Int){
        if(posicion >= 0 && posicion < listaCategorias.size){
            val categoria = listaCategorias[posicion]
            vista.mostrarMensajeExito(categoria.id,categoria.categoria)
            cargarProductos(categoria.id)
        }
    }
    private fun cargarProductos(categoriaId: Int) {

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val productos = modeloProductos.obtenerProductosPorCategoria(categoriaId)
                vista.mostrarProductos(productos)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar productos: " + e.localizedMessage)

            }
        }
    }

    fun seleccionarProducto(producto: dataProductos) {
        val precioDouble = producto.precio.toDoubleOrNull() ?: 0.0
        vista.abrirDetalleProducto(producto.id, producto.nombre, producto.descripcion, precioDouble)
    }
}