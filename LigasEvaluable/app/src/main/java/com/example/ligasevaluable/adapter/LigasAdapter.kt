package com.example.ligasevaluable.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ligasevaluable.R
import com.example.ligasevaluable.ui.model.Liga

class LigasAdapter(private val ligas: List<Liga>, private  val context: Context, private val onClick:(Liga) -> Unit): RecyclerView.Adapter<LigasAdapter.MyHolder>() {
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            //Referenciamos
        private val nombre_Liga: TextView = itemView.findViewById(R.id.nombre_Liga)

        //Recibe la liga y se enlaza con el diseño

        fun enlace(liga: Liga){
            nombre_Liga.text = liga.nombre
            itemView.setOnClickListener{
                onClick(liga)
            }
        }
    }
    // Se infla el layout item_liga para cada item de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_liga, parent, false)
        return MyHolder(view)
    }
        //devuelve la cantidad de items
    override fun getItemCount(): Int {
        return ligas.size
    }
    //Enlaza los datos con cada viewHolder
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.enlace(ligas[position])
    }
}