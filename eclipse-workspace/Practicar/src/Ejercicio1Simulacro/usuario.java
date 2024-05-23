package Ejercicio1Simulacro;

import java.util.ResourceBundle.Control;

public class usuario {

//Atributos
	protected String nombre, contraseña, dni;

	
	
//Constructor
	protected usuario() {
		
	}

	protected usuario(String nombre, String contraseña, String dni) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.dni = dni;
	}

	
//Getters & Setters
	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getContraseña() {
		return contraseña;
	}

	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}
	
	public String toString(){
		return "Nombre:"  +nombre+" "+ "Contraseña:" +contraseña+ " "+ "DNI:"  +dni;
	}
	
}
