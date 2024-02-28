package AlquilerVehiculos;

public class Vehiculo {
	protected String matricula;
    protected int diasAlquiler;

    public Vehiculo(String matricula, int diasAlquiler) {
        this.matricula = matricula;
        this.diasAlquiler = diasAlquiler;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public double calcularPrecioBase() {
        return 50 * diasAlquiler;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Días de alquiler: " + diasAlquiler;
    }
}

