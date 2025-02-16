package com.example.tienda.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evaluable2.R
import com.example.tienda.model.Producto

// Adaptador para la lista de productos en el carrito dentro de SecondActivity
class CarritoAdapter(private val carrito: List<Producto>) : RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder>() {

    inner class CarritoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagenProducto: ImageView = view.findViewById(R.id.imagenProducto)
        val nombreProducto: TextView = view.findViewById(R.id.nombreProducto)
        val precioProducto: TextView = view.findViewById(R.id.precioProducto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carrito, parent, false)
        return CarritoViewHolder(view)
    }


    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val producto = carrito[position]
        holder.nombreProducto.text = producto.nombre
        holder.precioProducto.text = "$${producto.precio}"
        Glide.with(holder.itemView.context).load(producto.imagenUrl).into(holder.imagenProducto)
    }

    override fun getItemCount(): Int = carrito.size
}
