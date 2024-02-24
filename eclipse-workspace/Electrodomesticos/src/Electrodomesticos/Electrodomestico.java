package Electrodomesticos;

public class Electrodomestico {
	
	//Atributos
	protected static final String COLOR_DEFECTO= "blanco";
	protected static final char CONSUMOENERGETICO_DEFECTO='F';
	protected static final double PRECIOBASE_DEFECTO=100;
	protected static final double PESO_DEFECTO=5;
	
	protected String color;
	protected char consumoEnergetico;
	protected double peso;
	protected double precioBase;
	
	
	//Constructores
	public Electrodomestico() {

	}


	public Electrodomestico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.peso = peso;
		
	}


	public Electrodomestico(String color, char consumoEnergetico, double peso, double precioBase) {
		this.color = color;
		this.consumoEnergetico = consumoEnergetico;
		this.peso = peso;
		this.precioBase = precioBase;
	}

	//Métodos get
	public String getColor() {
		return color;
	}


	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}


	public double getPeso() {
		return peso;
	}


	public double getPrecioBase() {
		return precioBase;
	}

	// Método para comprobar el consumo energético
    public char comprobarConsumoEnergetico(char letra) {
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        } else {
            return CONSUMOENERGETICO_DEFECTO;
        }
    }
	
 // Método para comprobar el color
    public String comprobarColor(String color) {
        String coloresDisponibles [] = {"blanco", "negro", "rojo", "azul", "gris"};
        for (String colorDisponible : coloresDisponibles) {
            if (colorDisponible.equalsIgnoreCase(color)) {
                return color;
            }
        }
        return COLOR_DEFECTO;
    }
    
 // Método para calcular el precio final
    public double precioFinal() {
        double precioFinal = precioBase;

        switch (consumoEnergetico) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 50;
                break;
            case 'E':
                precioFinal += 30;
                break;
            case 'F':
                precioFinal += 10;
                break;
        }

        if (peso >= 0 && peso <=19) {
            precioFinal += 10;
        } else if (peso >= 20 && peso <=49) {
            precioFinal += 50;
        } else if (peso >= 50 && peso <= 79) {
            precioFinal += 80;
        } else if (peso >= 80) {
            precioFinal += 100;
        }

        return precioFinal;
    }
}

