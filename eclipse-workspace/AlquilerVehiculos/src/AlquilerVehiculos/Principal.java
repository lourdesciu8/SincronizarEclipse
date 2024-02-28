package AlquilerVehiculos;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Vehiculo> vehiculosArray = new ArrayList<>();

        Vehiculo v1=new Coche("111AHK", 8, 4);
        Vehiculo v2=new Microbus("444DQF", 3, 6);
        Vehiculo v3=new FurgonetaCarga("777PKL", 4, 3.5);
        Vehiculo v4=new Camion("123JLE", 2);
		
		vehiculosArray.add(v1);
        vehiculosArray.add(v2);
        vehiculosArray.add(v3);
        vehiculosArray.add(v4);

        System.out.println("Precios de alquiler:");

        for (Vehiculo v : vehiculosArray) {
            System.out.println(v.toString() + ", Precio: " + v.calcularPrecioBase() + " euros");
        }
    }
}
