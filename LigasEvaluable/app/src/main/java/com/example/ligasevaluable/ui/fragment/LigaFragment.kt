package com.example.ligasevaluable.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ligasevaluable.adapter.EquipoAdapter
import com.example.ligasevaluable.databinding.FragmentLigaBinding
import com.example.ligasevaluable.ui.model.Equipo
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class LigaFragment: Fragment() {
    private lateinit var binding: FragmentLigaBinding
    private lateinit var database: DatabaseReference
    private lateinit var adapter: EquipoAdapter
    private val listaEquipos = mutableListOf<Equipo>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        //Obtiene el nombre de la liga enviada desde PrincipalFragment
        val nombreLiga = arguments?.getString("nombreLiga")
        Log.d("LigaFragment", "Recibido nombreLiga: $nombreLiga")


        //Inicializa la base de datos apuntando al nodo de la liga
        database = FirebaseDatabase.getInstance().getReference("ligas/$nombreLiga/equipos")
        Snackbar.make(binding.root, "Liga recibida: $nombreLiga", Snackbar.LENGTH_LONG).show()

        //Configura el Recyclerview con el adapter
        adapter = EquipoAdapter(requireContext(), listaEquipos){
            equipo ->
            Log.d("LigaFragment", "Liga recibida: $nombreLiga")
            /**Guardar como favorito los equipos y estos se guarden en firebas
            Se crea la referencia al nodo favoritos/nombreEquipo*/
            val favoritoSeleccionado = FirebaseDatabase.getInstance().getReference("favoritos/${equipo.nombre}")
            //Se guarda el objeto completo
            favoritoSeleccionado.setValue(equipo)
            //se notifica
            Snackbar.make(binding.root, "Guardando en favorito: ${equipo.nombre}", Snackbar.LENGTH_SHORT).show()
        }
        binding.recyclerEquipos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerEquipos.adapter = adapter


        //Escuchar los equipos desde firebase
        database.addValueEventListener(object : ValueEventListener{
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                listaEquipos.clear()
                for(equipoSnap in snapshot.children){
                    val nombre = equipoSnap.child("nombre").getValue(String::class.java)
                    val imagen = equipoSnap.child("imagen").getValue(String::class.java)
                    if(nombre != null && imagen != null){
                        listaEquipos.add(Equipo(nombre, imagen))
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}