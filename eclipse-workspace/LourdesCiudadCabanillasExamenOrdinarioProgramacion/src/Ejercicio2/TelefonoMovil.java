package Ejercicio2;

public class TelefonoMovil extends Producto {

	//Atributos
	protected String modelo, marca, memoria;
	protected double descuento;
	
	
	//Constructores
	protected TelefonoMovil(double precio, String modelo, String marca, String memoria, double descuento) {
		super(precio);
		this.modelo = modelo;
		this.marca = marca;
		this.memoria = memoria;
		this.descuento = descuento;
	}
	
	
	protected TelefonoMovil(double precio) {
		super(precio);
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


	protected double getDescuento() {
		return descuento;
	}


	protected void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	
	
	//Métodos
	public String toString() {
		return "Modelo: " +modelo + ", " +"Marca: " +marca +", " +"Memoria: " +memoria +", " + "Precio: " + precio +", " +"Descuento: " +descuento;
	}


		public boolean equals(TelefonoMovil t) {
			boolean iguales=false;
			if (t.getModelo().equals(modelo) && t.getMarca().equals(marca) && t.getMemoria().equals(memoria)
					&& t.getPrecio()==precio && t.getDescuento()==descuento ){
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
