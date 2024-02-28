package AlquilerVehiculos;

public class Coche extends Vehiculo {
	private int plazas;

    public Coche(String matricula, int diasAlquiler, int plazas) {
        super(matricula, diasAlquiler);
        this.plazas = plazas;
    }

    @Override
    public double calcularPrecioBase() {
        return super.calcularPrecioBase() + 1.5 * plazas * diasAlquiler;
    }
}
