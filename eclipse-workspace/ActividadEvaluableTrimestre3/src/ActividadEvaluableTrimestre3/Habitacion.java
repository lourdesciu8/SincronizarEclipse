package ActividadEvaluableTrimestre3;

public class Habitacion {
	//Poner clase como abstracta?
	
	//Atributos
	protected int numero;
    protected String tipo;
    protected double precioNoche;
    
    //Constructor
    protected Habitacion(int numero, String tipo, double precioNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
    }

    
   //Getters y Setters
    protected int getNumero() {
		return numero;
	}

    protected void setNumero(int numero) {
		this.numero = numero;
	}

    protected String getTipo() {
		return tipo;
	}

    protected void setTipo(String tipo) {
		this.tipo = tipo;
	}

    protected double getPrecioNoche() {
		return precioNoche;
	}

    protected void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}
    
	
	public String toString() {
        return "Habitación " + numero + " - Tipo: " + tipo + ", Precio por noche: " + precioNoche;
    }
    
    
}
