package AlquilerVehiculos;

public class FurgonetaCarga extends Vehiculo {
	private double pesoMaxAutorizado;

    public FurgonetaCarga(String matricula, int diasAlquiler, double pesoMaxAutorizado) {
        super(matricula, diasAlquiler);
        this.pesoMaxAutorizado = pesoMaxAutorizado;
    }

    @Override
    public double calcularPrecioBase() {
        return super.calcularPrecioBase() + 20 * pesoMaxAutorizado;
    }
}
