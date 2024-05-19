package ejercicio2;

public abstract class Producto {
    protected double precio;
    protected String marca, modelo, memoria;
    protected int descuento;

   

    protected Producto(double precio, String marca, String modelo, String memoria, int descuento) {
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
		this.memoria = memoria;
		this.descuento = descuento;
	}

	protected String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		this.marca = marca;
	}

	protected String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}

	protected String getMemoria() {
		return memoria;
	}

	protected void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	protected int getDescuento() {
		return descuento;
	}

	protected void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	protected double getPrecio() {
        return precio;
    }

    protected void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Producto: " +
        		"Marca: " + getMarca() + "\n" +
                "Modelo: " + getModelo() + "\n" +
                "Precio original: " + getPrecio() + "€\n" +
                "Descuento: " + getDescuento() + "%\n";
    }

	public abstract double calcularPrecioFinal();


}
