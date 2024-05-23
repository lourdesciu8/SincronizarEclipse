package Ejercicio2Simulacro;

public class TelefonoMovil extends Producto {

//Atributos	
protected String modelo, marca, memoria;
protected double descuento;


//Constructor
protected TelefonoMovil(double precio, String modelo, String marca, String memoria, double descuento) {
	super(precio);
	this.modelo = modelo;
	this.marca = marca;
	this.memoria = memoria;
	this.descuento = descuento;
}


//Getters & Setters
protected String getModelo() {
	return modelo;
}

protected void setModelo(String modelo) {
	this.modelo = modelo;
}

protected String getMarca() {
	return marca;
}

protected void setMarca(String marca) {
	this.marca = marca;
}

protected String getMemoria() {
	return memoria;
}

protected void setMemoria(String memoria) {
	this.memoria = memoria;
}

protected double getPrecio() {
	return precio;
}

protected void setPrecio(double precio) {
	this.precio = precio;
}

protected double getDescuento() {
	return descuento;
}

protected void setDescuento(double descuento) {
	this.descuento = descuento;
}

	
//Métodos
public String toString() {
	return "Modelo: " +modelo + " " +"Marca: " +marca +" " +"Memoria: " + memoria +" " + "Precio: " + precio +" " +"Descuento: " +descuento;
}

public boolean equals(TelefonoMovil tm) {
	boolean iguales=false;
	if (tm.getModelo().equals(modelo) && tm.getMarca().equals(marca) && tm.getMemoria().equals(memoria) 
			&& tm.getPrecio()==precio && tm.getDescuento()==descuento ){
		iguales=true;
	}
	return iguales;
}


@Override
public double calcularPrecioFinal() {
	double descuentoExacto=precio*(descuento/100);
	double Preciofinal=precio-descuentoExacto;
	return Preciofinal;
}

}
