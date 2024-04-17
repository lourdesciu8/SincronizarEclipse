package ActividadEvaluableTrimestre3;

public class Habitacion {
	
	//Atributos
	protected int numero;
    protected String tipo;
    protected double precioNoche;
    
    //Constructor
    public Habitacion(int numero, String tipo, double precioNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
    }

    
   //Getters y Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}
    
	
	public String toString() {
        return "Habitación " + numero + " - Tipo: " + tipo + ", Precio por noche: " + precioNoche;
    }
    
    
}
