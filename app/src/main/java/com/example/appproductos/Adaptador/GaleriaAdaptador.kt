package com.example.appproductos.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appproductos.R
import com.example.appproductos.modelo.dataImagenesProducto
import com.google.android.material.listitem.ListItemViewHolder

class GaleriaAdaptador(private var listaImagenes: List<dataImagenesProducto>): RecyclerView.Adapter<GaleriaAdaptador.GaleriaViewHolder>() {
    // Antes tenemos que crear una clase holder
    class GaleriaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        // Pendiente, inflar primera el layout
        val imgGaleria: ImageView = itemView.findViewById(R.id.imgGaleria)

    }

    // Estos tres funciones se van a programar, son contratos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriaViewHolder {
        // Vamos a inflar el layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_galeria, parent, false)
        return GaleriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: GaleriaViewHolder, position: Int) {
        val imagen = listaImagenes[position]
        val baseUrl = "http://10.115.233.118/tienda_api/" //aqui va el url de tu conexion
        val urlCompleta = baseUrl + imagen.urlImagen

        Glide.with(holder.itemView.context)
            .load(urlCompleta)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.imgGaleria)
    }

    override fun getItemCount(): Int {
        return listaImagenes.size
    }

    fun actualizarLista(nuevaLista: List<dataImagenesProducto>)
    {
        listaImagenes = nuevaLista
        notifyDataSetChanged()
    }
}