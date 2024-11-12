package Ejercicio1;

public class usuario {
	//Atributos
	protected String nombre, apellidos, dni;

	//Constructores
	protected usuario(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	protected usuario() {
	}
	
	//Getters & setters
	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}
	
	//Método toString para mostrar los datos del usuario
	public String toString(){
		return "Nombre:"  +nombre+", "+ "Apellidos:" +apellidos+ ", "+ "DNI:"  +dni;
	}
	
}
