package com.example.ligasevaluable.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ligasevaluable.R
import com.example.ligasevaluable.adapter.LigasAdapter
import com.example.ligasevaluable.databinding.FragmentPrincipalBinding
import com.example.ligasevaluable.ui.model.Liga
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class PrincipalFragment: Fragment() {
    private lateinit var binding: FragmentPrincipalBinding
    //Declaración de adapter Liga
    private lateinit var adapter: LigasAdapter
    //Declaración de variable para conectar a firebase
    private lateinit var database: DatabaseReference
    //lista vacía para recibir las ligas de firebase
    private val listaLigas = mutableListOf<Liga>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        //Habilita el menu en el fragmento Principal
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onStart() {
        super.onStart()

        //Se conecta con firebase
        database = FirebaseDatabase.getInstance().getReference("ligas")

        //Configura adapter y recycler
        adapter = LigasAdapter(listaLigas, requireContext()){
            ligaSeleccionada -> val bundle = Bundle()
            bundle.putString("nombreLiga", ligaSeleccionada.id)
            findNavController().navigate(R.id.action_principalFragment_to_ligaFragment, bundle)
        }
        //Se configura el recyclerview
        binding.recyclerLigas.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerLigas.adapter = adapter


        //Leer los datos
        database.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                listaLigas.clear()
                for (ligaSnap in snapshot.children){
                    val nombre = ligaSnap.child("nombre").getValue(String::class.java)
                    val id = ligaSnap.key
                    if(nombre != null && id != null){
                        listaLigas.add(Liga(nombre, id))
                    }
                }
                //Actualiza la lista
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    //Inflar el menu desde el xml
    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_principal, menu)
    }

    //Gestiona las acciones de menú
    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when ( item.itemId){
            //navegar a favorito
            R.id.menuFavorito -> {
                findNavController().navigate(R.id.action_principalFragment_to_favoritoFragment)
            true
        }
            //Al oprimir este botón se debe cerrar sesión y navega hasta el fragment login
            R.id.menuSalir -> {
                //cierre
                FirebaseAuth.getInstance().signOut()
                //navega
                findNavController().navigate(R.id.action_principalFragment_to_loginFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}