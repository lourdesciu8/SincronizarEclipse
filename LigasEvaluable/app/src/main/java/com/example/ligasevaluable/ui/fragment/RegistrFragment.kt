package com.example.ligasevaluable.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ligasevaluable.R
import com.example.ligasevaluable.databinding.FragmentRegistrBinding
import com.google.firebase.auth.FirebaseAuth

class RegistrFragment: Fragment() {
    private lateinit var binding: FragmentRegistrBinding
    //Objeto de autenticación
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        //Se iniciliza el auth
        auth = FirebaseAuth.getInstance()
        binding.btnRegistrar.setOnClickListener {
            //Se obtiene los datos
            val email = binding.correoNuevo.text.toString().trim()
            val pass = binding.passNuevo.text.toString().trim()

            //Se verifican si los campos están llenos
            if(email.isNotEmpty() && pass.isNotEmpty()){
                //que se registre en la base de datos
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    task ->
                    if(task.isSuccessful){
                        Toast.makeText(context, "Registrado Correctamente", Toast.LENGTH_SHORT).show()
                        //Se dirige directamente a principal
                        findNavController().navigate(R.id.action_registrFragment_to_principalFragment)
                    }else{
                        Toast.makeText(context, "Error al registrar: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
                }else{
                Toast.makeText(context, "Campos vacios deben ser llenados", Toast.LENGTH_SHORT).show()
            }
        }
        //Navegacion del registro al login
        binding.btnInciar.setOnClickListener {
            findNavController().navigate(R.id.action_registrFragment_to_loginFragment)
        }
    }
}