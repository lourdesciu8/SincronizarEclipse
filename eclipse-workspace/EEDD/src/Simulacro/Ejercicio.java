package Simulacro;

public class Ejercicio {
	 // Atributos
    public int numeroPistas;
    public int numeroEsquiadores;
    public String nombreEstacion;
    public double costoForfait = 50.0;

    // Constructores
    public Ejercicio(int numeroPistas, int numeroEsquiadores, String nombreEstacion, double costoForfait) {
		this.numeroPistas = numeroPistas;
		this.numeroEsquiadores = numeroEsquiadores;
		this.nombreEstacion = nombreEstacion;
		this.costoForfait = costoForfait;
	}

    public Ejercicio(int numeroPistas, int numeroEsquiadores, double costoForfait) {
		this.numeroPistas = numeroPistas;
		this.numeroEsquiadores = numeroEsquiadores;
		this.costoForfait = costoForfait;
	}


	// Métodos getters y setters 
    public int getNumeroPistas() {
		return numeroPistas;
	}

    public void setNumeroPistas(int numeroPistas) {
		this.numeroPistas = numeroPistas;
	}

    public int getNumeroEsquiadores() {
		return numeroEsquiadores;
	}

    public void setNumeroEsquiadores(int numeroEsquiadores) {
		this.numeroEsquiadores = numeroEsquiadores;
	}

    public String getNombreEstacion() {
		return nombreEstacion;
	}

    public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}

    public double getCostoForfait() {
		return costoForfait;
	}

    public void setCostoForfait(double costoForfait) {
		this.costoForfait = costoForfait;
	}


    // Método para calcular cantidad total recaudada en un día 
    public double CalcularCantidadTotal( int numeroPistas, int numeroEsquiadores,double costoForfait) {
       
        double CantidadTotal = numeroPistas * numeroEsquiadores * costoForfait;
        return CantidadTotal;
    }

}
