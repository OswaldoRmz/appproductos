package com.example.appproductos.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appproductos.Adaptador.GaleriaAdaptador.GaleriaViewHolder
import com.example.appproductos.R
import com.example.appproductos.modelo.dataProductos
import com.example.appproductos.vista.MainActivity

class ProductosAdaptador(private val activity: MainActivity, private var listaProducto: List<dataProductos>): RecyclerView.Adapter<ProductosAdaptador.ProductoViewHolder>(){

    class ProductoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNombre: TextView = itemView.findViewById(R.id.txtProducto)
        val tvPrecio: TextView = itemView.findViewById(R.id.txtPrecio)
        val imgProducto: ImageView = itemView.findViewById(R.id.imgProducto)
    }
    // Estos tres funciones se van a programar, son contratos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        // Vamos a inflar el layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProducto[position]
        holder.tvNombre.text = producto.nombre
        holder.tvPrecio.text = "$ "+producto.precio.toString()

        val baseUrl = "http://10.115.233.118/tienda_api/" //aqui va el url de tu conexion
        val urlImagenCompleta = baseUrl + producto.urlimagenprincipal

        Glide.with(holder.itemView.context)
            .load(urlImagenCompleta)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.imgProducto)

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //Esta funcion se ejecuta em la vista MainActivity
                // y se manda al presentador para que se muestre el prod seleccionado
                activity.seleccionarProducto(producto)
            }
        })
    }

    override fun getItemCount(): Int {
        return listaProducto.size
    }

    fun actualizarLista(nuevaLista: List<dataProductos>){
        listaProducto = nuevaLista
        notifyDataSetChanged()
    }
}