package concesionario;

import java.util.ArrayList;
import java.util.Scanner;

import EjercicioPersonas.Persona;

public class principalConcesionario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dni, nombre, apellidos;
		int opcion;
		String matricula, marca;
		
		clientes c1;
		vehiculos v1;
		
		//Se crean 2 arraylist, uno para cada clase creada
		ArrayList<clientes>clientesConcesionario=new ArrayList<clientes>();
		ArrayList<vehiculos>vehiculosConcesionario=new ArrayList<vehiculos>();
		
		/*clientes c1=new clientes("53736069L","Lourdes","Ciudad");
		clientes c2=new clientes("53736069L","Lourdes","Ciudad","mujer","lourdes@gmail.com");
	    clientes c3=new clientes();
	    
	    clientesConcesionario.add(c1);
	    clientesConcesionario.add(c2);
	    clientesConcesionario.add(c3);
	    */

	    do {
			System.out.println("1.- Dar de alta a un cliente");
			System.out.println("2.- Dar de baja a un cliente");
			System.out.println("3.- Dar de alta un vehículo");
			System.out.println("4.- Dar de baja un vehículo");
			System.out.println("5.- Salir");
			opcion=sc.nextInt();
			switch(opcion) {
				case 1: System.out.println("Dime dni del cliente: ");
						dni=sc.next();
						System.out.println("Dime el nombre: ");
						nombre=sc.next();
						System.out.println("Dime los apellidos: ");
						apellidos=sc.next();
						c1=new clientes(dni,nombre, apellidos);
						clientesConcesionario.add(c1);
						System.out.println("Cliente dado de alta");
						
					break;
				case 2: System.out.println("Dime dni del cliente: ");
						dni=sc.next();
						for(clientes c1: clientesConcesionario) {
					    	if(c1.getDni().equals("53736069L")) {
					    		clientesConcesionario.remove(c1);
					    		System.out.println("Cliente eliminado");
						    }
					    }
					break;
						
				case 3: System.out.println("Dime matrícula del vehículo: ");
				matricula=sc.next();
				System.out.println("Dime marca del vehículo: ");
				marca=sc.next();
				v1=new vehiculos(matricula, marca);
				vehiculosConcesionario.add(v1);
				System.out.println("Vehículo dado de alta");
				
					break;
				case 4: System.out.println("Dime matrícula del vehículo: ");
				matricula=sc.next();
				for(vehiculos v1: vehiculosConcesionario) {
			    	if(v1.getMatrícula().equals("8974JKG")) {
			    		vehiculosConcesionario.remove(v1);
			    		System.out.println("Vehículo eliminado");
				    }
			    }
			break;
			
				case 5: System.out.println("Salir");
			}
		}while (opcion!=5);

	}

}
