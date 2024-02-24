package Electrodomesticos;

public class Television extends Electrodomestico {

	// Atributos
    protected static final double RESOLUCION_DEFECTO = 20;
    protected static final boolean SINTONIZADOR_DEFECTO = false;

    protected double resolucion;
    protected boolean sintonizador;
	
    //Constructores
    public Television() {
		super();
	}

	public Television(double precioBase, double peso) {
		super(precioBase, peso);
	}

	public Television(String color, char consumoEnergetico, double peso, double precioBase, double resolucion,
			boolean sintonizador) {
		super(color, consumoEnergetico, peso, precioBase);
		this.resolucion = resolucion;
		this.sintonizador = sintonizador;
	}

    
    //Métodos get
	public double getResolucion() {
		return resolucion;
	}

	public boolean getSintonizador() {
		return sintonizador;
	}

	// Método para calcular el precio final
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (resolucion > 40) {
            precioFinal += precioFinal * 0.3;
        }

        if (sintonizador) {
            precioFinal += 50;
        }

        return precioFinal;
    }
}

   
