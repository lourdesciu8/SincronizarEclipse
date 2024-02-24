package Electrodomesticos;

public class Lavadora extends Electrodomestico{

    // Atributos
	protected static final double CARGA_DEFECTO = 5;
	protected double carga;
	
	
	//Constructores
	public Lavadora() {
		super();
	}


	public Lavadora(double precioBase, double peso) {
		super(precioBase, peso);
	}


	public Lavadora(String color, char consumoEnergetico, double peso, double precioBase, double carga) {
		super(color, consumoEnergetico, peso, precioBase);
		this.carga = carga;
	}


	
	//Método get de carga
	public double getCarga() {
		return carga;
	}
	
	// Método para calcular el precio final
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (carga > 30) {
            precioFinal += 50;
        }

        return precioFinal;
    }
    
    
}


	
