package AlquilerVehiculos;

public class Microbus extends Vehiculo {
	private int plazas;

    public Microbus(String matricula, int diasAlquiler, int plazas) {
        super(matricula, diasAlquiler);
        this.plazas = plazas;
    }

    @Override
    public double calcularPrecioBase() {
        return super.calcularPrecioBase() + (1.5 * plazas + 2) * diasAlquiler;
    }
}
