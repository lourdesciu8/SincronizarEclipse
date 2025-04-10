package com.example.ligasevaluable.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ligasevaluable.R
import com.example.ligasevaluable.ui.model.Equipo

class EquipoAdapter(
    //Se necesita Context para glide
    private val context: Context,
    //lista de equipo
    private val listaEquipo: List<Equipo>,
    //Acción para marcar como favorito
    private val onFavoritoClick: (Equipo) -> Unit
): RecyclerView.Adapter<EquipoAdapter.MyHolder>() {

    //ViewHolder para cada tarjeta de equipo (usa item_equipo.xml)
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imagen: ImageView = itemView.findViewById(R.id.imagenEquipo)
        private val nombre: TextView = itemView.findViewById(R.id.nombre_equipo)
        private val btnFavorito: Button = itemView.findViewById(R.id.btnFavorito)

        //metodo que lanza los datos del equipo con la vista
        fun enlazar(equipo: Equipo){
            nombre.text = equipo.nombre

            //Cargar imagen desde la URL usando Glide
            Glide.with(context)
                .load(equipo.imagen)
                .into(imagen)

            //Acción al pulsar el botón de favorito
            btnFavorito.setOnClickListener {
                onFavoritoClick(equipo)
            }
        }
    }
    //infla la vista del equipo desde el item_equipo.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_equipo, parent, false)
        return MyHolder(view)
    }
    //Devuelve la cantidad del equipo
    override fun getItemCount(): Int {
        return listaEquipo.size
    }
    //Acción al pulsar el botón
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.enlazar(listaEquipo[position])
    }
}