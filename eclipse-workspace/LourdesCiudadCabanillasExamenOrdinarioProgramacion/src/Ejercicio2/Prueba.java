package Ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		
		//Se crea un arraylist de tipo Producto y se le añaden objetos de tipo tablet y telefono movil
		ArrayList<Producto> arrayproduct = new ArrayList<Producto>();
		
		Producto p1=new Tablet(540, "Samsung", "Pro", "64", 10);
		Producto p2=new TelefonoMovil(1000, "Apple", "XS", "128",25);
		
		//Se crean objetos y se añaden al ArrayList
		arrayproduct.add(p1);
		arrayproduct.add(p2);
		
		//Recorrer el arraylist y mostrar datos por pantalla
		for (Producto item : arrayproduct) {
			if (item instanceof Tablet) {
                System.out.println((Tablet)item);
                System.out.println("Precio final: " +item.calcularPrecioFinal() +"€\n");
            } else if (item instanceof TelefonoMovil) {
                System.out.println((TelefonoMovil)item );
                System.out.println("Precio final: " +item.calcularPrecioFinal() +"€\n");
            }
		} 
		
	}

}
