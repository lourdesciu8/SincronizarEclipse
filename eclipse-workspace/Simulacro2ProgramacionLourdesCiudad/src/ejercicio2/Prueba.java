package ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		ArrayList <Producto> productosArray = new ArrayList<Producto>();

		//Se crean objetos de tipo TelefonoMovil y Tablet y se añaden al ArrayList
		TelefonoMovil tm = new TelefonoMovil(400, "Samsung", "Galaxy", "200", 10);
		productosArray.add(tm);
		Tablet ta = new Tablet(200, "Samsung", "GalaxyPro", "130", 20);
		productosArray.add(ta);	
		
		//Se recorre el ArrayList con un foreach
		for (Producto item : productosArray) {
			if (item instanceof TelefonoMovil) {
                System.out.println(item.toString()+ "Precio final: " +item.calcularPrecioFinal()+ "€\n");
 
            } else if (item instanceof Tablet) {
                System.out.println(item.toString() +"Precio final: "+item.calcularPrecioFinal()+ "€\n");
            }
		}

		
	}

}
