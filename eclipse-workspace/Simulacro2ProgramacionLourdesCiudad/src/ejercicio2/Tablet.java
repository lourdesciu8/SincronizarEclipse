package ejercicio2;

public class Tablet extends Producto {

    public Tablet(double precio, String marca, String modelo, String memoria, int descuento) {
		super(precio, marca, modelo, memoria, descuento);
	}

	public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Tablet) {
			return this.marca.equals(((Tablet)obj).getMarca()) 
					&& this.modelo.equals(((Tablet)obj).getModelo()) &&
					this.memoria.equals(((Tablet)obj).getMemoria());
		}else {
			return super.equals(obj);
		}
	}
	/*Otra forma: 
	 public boolean equals(Tablet t) {
	 if(t.getModelo().equals(modelo) && t.getMarca().equals(marca) && t.getMemoria().equals(memoria)){
	 	return true;
	 }else{
	 return false;
	 }
	 */
	 

	@Override
    public String toString() {
        return "\nTablet: \n" +
                "Marca: " + getMarca() + "\n" +
                "Modelo: " + getModelo() + "\n" +
                "Precio original: " + getPrecio() + "€\n" +
                "Descuento: " + getDescuento() + "%\n";
    }

	@Override
	public double calcularPrecioFinal() {
		
		double descuentoExacto = getPrecio() * (getDescuento() / 100.0);
		double precioFinal = getPrecio() - descuentoExacto;
		
		return precioFinal;
	}

	

   
}