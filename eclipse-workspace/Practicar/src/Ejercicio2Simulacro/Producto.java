package Ejercicio2Simulacro;

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
	
	//Método calcular precio final
	public abstract double calcularPrecioFinal();
}
