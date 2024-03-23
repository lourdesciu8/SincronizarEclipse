package ElectrodomesticosOK;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Electrodomestico> e = new ArrayList();
		Scanner sc = new Scanner (System.in);
		int opcion;
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch (opcion) {
				case 1:
					//Lavadora l1 = new Lavadora();
					//e.add(l1);
					altaLavadora(sc, e);
					break;
				case 2:
					//Television t1 = new Television(400,5,"negro",'C',56,true);
					//e.add(t1);
					altaTelevision(sc, e);
					break;
				case 3:
					calcularPrecioFinalElectrodomesticos(e);
					break;
				case 4:
					calcularPrecioFinalTelevisiones(e);
					break;
				case 5:
					calcularPrecioFinalLavadoras(e);
					break;
				case 6:
					System.out.println("¡Que tengas un buen día! \n");
					break;
				default:
		            System.out.println("Opción no válida \n");
		            break;
			}
		}while(opcion!=6);
	}
		
	public static void altaTelevision(Scanner sc, ArrayList<Electrodomestico> e) {
	    System.out.println("Introduce el precio base:");
	    double precioBase = sc.nextDouble();
	    System.out.println("Introduce el peso:");
	    double peso = sc.nextDouble();
	    System.out.println("Introduce el color:");
	    String color = sc.next();
	    System.out.println("Introduce el consumo energético:");
	    char consumoEnergetico = Character.toUpperCase(sc.next().charAt(0));
	    System.out.println("Introduce la resolución:");
	    double resolucion = sc.nextDouble();
	    System.out.println("¿Tiene sintonizador TDT? (true/false):");
	    boolean sintonizadorTdt = sc.nextBoolean();

	    Television television = new Television(precioBase, peso, color, consumoEnergetico, resolucion, sintonizadorTdt);
	    e.add(television);
	    System.out.println("Televisión agregada correctamente.\n Tendra un precio a la venta de: " + television.getPrecioBase() + " euros \n");
	}

	public static void altaLavadora(Scanner sc, ArrayList<Electrodomestico> e) {
	    System.out.println("Introduce el precio base:");
	    double precioBase = sc.nextDouble();
	    System.out.println("Introduce el peso:");
	    double peso = sc.nextDouble();
	    System.out.println("Introduce el color:");
	    String color = sc.next();
	    System.out.println("Introduce el consumo energético:");
	    char consumoEnergetico = Character.toUpperCase(sc.next().charAt(0));
	    System.out.println("Introduce la carga:");
	    int carga = sc.nextInt();

	    Lavadora lavadora = new Lavadora(precioBase, peso, color, consumoEnergetico, carga);
	    e.add(lavadora);
	    System.out.println("Lavadora agregada correctamente.\n Tendrá un precio a la venta de: " + lavadora.getPrecioBase() + " euros \n");
	}
		
	public static void calcularPrecioFinalTelevisiones(ArrayList<Electrodomestico>e) {
		// Creamos e iniciamos la variable de precioTotalTelevisiones fuera del bucle
	    double precioTotalTelevisiones = 0;
		// Recorremos el ArrayList con un foreach
		for (Electrodomestico _television : e) {
			if (_television instanceof Television) {
			 	Television varTelevision = (Television) _television; // Se hace un casting de _television a Television
	            precioTotalTelevisiones += varTelevision.getPrecioBase();
	        } 
		}
		// Mostramos resultado de cada suma por tipo de objeto
	    System.out.println("Precio total de todas las televisiones: " + precioTotalTelevisiones + " euros \n");
	}
		
	public static void calcularPrecioFinalLavadoras(ArrayList<Electrodomestico>e) {
		// Creamos e iniciamos la variable de precioTotalLavadoras fuera del bucle
		double precioTotalLavadoras = 0;
		// Recorremos el ArrayList con un foreach
		for (Electrodomestico _lavadora : e) {
			if (_lavadora instanceof Lavadora) { 
				Lavadora varLavadora = (Lavadora) _lavadora; // Se hace un casting de _lavadora a Lavadora
				precioTotalLavadoras += varLavadora.getPrecioBase(); 
			} 
		}
		// Mostramos resultado de cada suma por tipo de objeto
		System.out.println("Precio total de todas las lavadoras: " + precioTotalLavadoras + " euros");
	}
		
	public static void calcularPrecioFinalElectrodomesticos(ArrayList<Electrodomestico>e) {
		// Creamos e iniciamos la variable de precioTotalElectrodomesticos fuera del bucle
		double precioTotalElectrodomesticos = 0;
		// Recorremos el ArrayList con un foreach
		for (Electrodomestico _electrodomestico : e) {
			if (_electrodomestico instanceof Electrodomestico) { 
			Electrodomestico varElectrodomestico = (Electrodomestico) _electrodomestico; // Se hace un casting de _electrodomestico a Electrodomestico
			precioTotalElectrodomesticos += varElectrodomestico.getPrecioBase(); 
			} 
		}
		// Mostramos resultado de cada suma por tipo de objeto
		System.out.println("Precio total de todas las lavadoras: " + precioTotalElectrodomesticos + " euros");
	}
	
	public static void mostrarMenu() {
		System.out.println("----- Menú de opciones -----");
		System.out.println("1. Dar de alta lavadora");
		System.out.println("2. Dar de alta televisor");
		System.out.println("3. Mostrar precio final de todos los electrodomésticos");
		System.out.println("4. Mostrar precio final de todos los televisores");
		System.out.println("5. Mostrar precio final de todas las lavadoras");
		System.out.println("6. Salir");
	}
}
