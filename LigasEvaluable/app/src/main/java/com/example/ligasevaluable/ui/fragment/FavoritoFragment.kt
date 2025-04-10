package com.example.ligasevaluable.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ligasevaluable.adapter.EquipoAdapter
import com.example.ligasevaluable.databinding.FragmentFavoritoBinding
import com.example.ligasevaluable.ui.model.Equipo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FavoritoFragment: Fragment() {
    private lateinit var binding: FragmentFavoritoBinding
    //declara la variable adapter
    private lateinit var adapter: EquipoAdapter
    //variable para conectar con firebase
    private lateinit var database: DatabaseReference
    //lista vacia de los equipos favoritos
    private val listaFavoritos = mutableListOf<Equipo>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        //Referencia de nodos favoritos en firebase
        database = FirebaseDatabase.getInstance().getReference("favoritos")

        //Configuracion de recycler y el adapter
        adapter = EquipoAdapter(requireContext(), listaFavoritos){

        }
        binding.recyclerEquipos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerEquipos.adapter = adapter

        //Se escucha los favoritos guardados
        database.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                listaFavoritos.clear()
                for(favoritoSnap in snapshot.children){
                    val nombre = favoritoSnap.child("nombre").getValue(String::class.java)
                    val imagen = favoritoSnap.child("imagen").getValue(String::class.java)
                    if(nombre != null && imagen != null){
                        listaFavoritos.add(Equipo(nombre, imagen))
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

}