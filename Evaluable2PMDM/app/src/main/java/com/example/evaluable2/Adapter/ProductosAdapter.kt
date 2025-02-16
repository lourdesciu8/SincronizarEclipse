package com.example.evaluable2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evaluable2.R
import com.example.tienda.model.Producto
import com.google.android.material.snackbar.Snackbar

// Adaptador para la lista de productos en MainActivity
class ProductosAdapter(
    private val listaProductos: List<Producto>,
    private val onAgregarAlCarrito: (Producto) -> Unit
) : RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder>() {

    inner class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagenProducto: ImageView = view.findViewById(R.id.imagenProducto)
        val nombreProducto: TextView = view.findViewById(R.id.nombreProducto)
        val precioProducto: TextView = view.findViewById(R.id.precioProducto)
        val botonAgregar: Button = view.findViewById(R.id.botonAgregar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]
        holder.nombreProducto.text = producto.nombre
        holder.precioProducto.text = "${producto.precio}€"
        Glide.with(holder.itemView.context).load(producto.imagenUrl).into(holder.imagenProducto)

        holder.botonAgregar.setOnClickListener {
            onAgregarAlCarrito(producto)
            Snackbar.make(it, "${producto.nombre} añadido al carrito", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listaProductos.size


}
