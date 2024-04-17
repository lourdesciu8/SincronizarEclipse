package FigurasGeometricas;

import java.net.NoRouteToHostException;

public class Circulo extends Figura2D {

//Atributo
protected double radio;

//Constructor con parámetros
public Circulo(String nombre, double radio) {
	super(nombre);
	this.radio = radio;
}

//Getters & Setters
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getRadio() {
	return radio;
}

public void setRadio(double radio) {
	this.radio = radio;
}

//Calculamos perímetro
public double calcularPerimetro() {
    return 2 * Math.PI * radio;
}

public String toString() {
    return "Círculo nombre=" + nombre + ", radio=" + radio + "";
}

public boolean equals(Circulo c) {
	boolean iguales=false;
	if(c.getNombre().equals(nombre) && (c.getRadio()==radio)){
	
		//radio al ser de tipo double y no String como nombre, no se puede utilizar equals para la comparación sino ==
		iguales=true;
		}
	return iguales;
	}
}
