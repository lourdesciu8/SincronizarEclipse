package Electrodomesticos;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		//Se crea un arraylist de electrodomésticos
		ArrayList <Electrodomestico> electrodomesticosArray = new ArrayList <Electrodomestico>();
		
		//Se crean objetos para dar de alta lavadoras y televisores
		Lavadora l1=new Lavadora();
		Lavadora l2=new Lavadora(100,50);
		Television t1=new Television();
		Television t2=new Television(120,40);
		
		//Se añaden los objetos (electrodomésticos) al ArrayList
		 electrodomesticosArray.add(l1);
		 electrodomesticosArray.add(l2);
		 electrodomesticosArray.add(t1);
		 electrodomesticosArray.add(t2);
		 
		// Mostrar el precio final
	        double precioTotalElectrodomesticos = 0;
	        double precioTotalLavadoras = 0;
	        double precioTotalTelevisiones = 0;

	        for (Electrodomestico elec : electrodomesticosArray) {
	            double precioFinal = elec.precioFinal();
	            precioTotalElectrodomesticos += precioFinal;

	            if (elec instanceof Lavadora) {
	                precioTotalLavadoras += precioFinal;
	            } else if (elec instanceof Television) {
	                precioTotalTelevisiones += precioFinal;
	            }
	        }

	        System.out.println("Precio total de Electrodomésticos: " + precioTotalElectrodomesticos);
	        System.out.println("Precio total de Lavadoras: " + precioTotalLavadoras);
	        System.out.println("Precio total de Televisiones: " + precioTotalTelevisiones);
	}

}
