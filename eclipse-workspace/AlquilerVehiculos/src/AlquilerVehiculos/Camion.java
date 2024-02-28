package AlquilerVehiculos;

public class Camion extends Vehiculo {
	public Camion(String matricula, int diasAlquiler) {
        super(matricula, diasAlquiler);
    }

    @Override
    public double calcularPrecioBase() {
        return super.calcularPrecioBase() + 40;
    }
}
