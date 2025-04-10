package com.example.ligasevaluable.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ligasevaluable.R
import com.example.ligasevaluable.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment: Fragment() {
    private lateinit var binding: FragmentLoginBinding
    //Auth es el objeto para autenticar en firebase
    private lateinit var auth: FirebaseAuth
    //Primer ciclo del fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        //Inicialización de firebaseAuth
        auth = FirebaseAuth.getInstance()
        //Y al hacer click en iniciar de iniciarSesión
        binding.btnInciar.setOnClickListener {
            //se obtiene los datos
            val email = binding.editCorreo.text.toString().trim()
            val pass = binding.editPass.text.toString().trim()
            //y se verifican.
            if(email.isNotEmpty() && pass.isNotEmpty()){
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{
                    task ->
                    if(task.isSuccessful){
                        //Si los datos son correctos se dirige al principal
                        findNavController().navigate(R.id.action_loginFragment_to_principalFragment)
                    }else{
                        Toast.makeText(context, "Correo o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context, "Campos vacios, deben ser llenado", Toast.LENGTH_SHORT).show()
            }
        }
        //se dirige al registro
        binding.btnRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrFragment)
        }
    }
}