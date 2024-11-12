package Ejercicio2;

public abstract class Producto {

	//Atributos
	protected double precio;

	//Constructor
	protected Producto(double precio) {
		this.precio = precio;
	}

	
	//Getters & setters 
	protected double getPrecio() {
		return precio;
	}

	protected void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//Método abstracto para calcular el precio final
	public abstract double calcularPrecioFinal();
	
}
