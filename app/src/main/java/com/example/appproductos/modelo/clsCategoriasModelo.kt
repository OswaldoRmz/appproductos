package com.example.appproductos.modelo

class clsCategoriasModelo {
    suspend fun obtenerCategorias(): List<dataCategorias>{
        val datos = RetrofitCliente.apiService.obtenerCategorias()//pedido a la BD

        val listaFinal = mutableListOf(dataCategorias(0,"Todas las categorias"))
        listaFinal.addAll(datos)

        return listaFinal //retorna la lista directamente
    }
}