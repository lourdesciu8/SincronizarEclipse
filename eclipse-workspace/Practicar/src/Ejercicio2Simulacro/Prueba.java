package Ejercicio2Simulacro;

import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		ArrayList<Producto> arrayProductos=new ArrayList<Producto>();
		
		//Tablet t=new Tablet(400, "Samsung", "Galaxy", "50", 10);
		//TelefonoMovil tm=new TelefonoMovil(550, "Apple", "IphoneX", "200", 25);
		//arrayProductos.add(t);
		//arrayProductos.add(tm);
		//System.out.println(item.toString() + "Precio final:" +item.calcularPrecioFinal());
		
		Producto p1=new Tablet(260, "Samsung", "Galaxy", "50", 50);
		Producto p2=new TelefonoMovil(700, "Apple", "IphoneX", "200", 10);
		
		//Se crean objetos y se añaden al ArrayList
		arrayProductos.add(p1);
		arrayProductos.add(p2);
		
		for (Producto item : arrayProductos) {
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
