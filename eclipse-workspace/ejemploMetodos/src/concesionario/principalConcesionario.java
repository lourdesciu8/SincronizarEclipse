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
	    	mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1: System.out.println("Dime dni del cliente: ");
						dni=sc.next();
						boolean existecliente=false;
						for(clientes c2: clientesConcesionario) {
					    	if(c2.getDni().equals(dni)) {
								System.out.println("No se puede dar de alta. El cliente ya está en la base de datos");
								existecliente=true;
								break;
							}
						}
						if(!existecliente) {
							System.out.println("Dime el nombre: ");
							nombre=sc.next();
							System.out.println("Dime los apellidos: ");
							apellidos=sc.nextLine();
							sc.nextLine();
							c1=new clientes(dni,nombre, apellidos);
							clientesConcesionario.add(c1);
							System.out.println("Cliente dado de alta");
						}
						
					break;
								
				case 2: System.out.println("Dime dni del cliente: ");
						dni=sc.next();
						for(clientes c2: clientesConcesionario) {
					    	if(c2.getDni().equals(dni)) {
					    		clientesConcesionario.remove(c2);
					    		System.out.println("Cliente eliminado");
					    		break;
						    }else {
						    	System.out.println("Cliente no eliminado, no se encuentra guardado");
						    }
					    }
					break;
					
				case 3:  System.out.println("Clientes actuales guardados: ");
				for(clientes c2:clientesConcesionario) {
					System.out.println(c2.getNombre()+" " +"con DNI "+c2.getDni());
				}
				break;
						
				case 4: System.out.println("Dime matrícula del vehículo: ");
				matricula=sc.next();
				boolean existevehiculo=false;
				for(vehiculos c2: vehiculosConcesionario) {
			    	if(c2.getMatrícula().equals(matricula)) {
						System.out.println("No se puede dar de alta. El vehículo ya está en la base de datos");
						existevehiculo=true;
						break;
					}
				}
				
				if(!existevehiculo) {
				System.out.println("Dime marca del vehículo: ");
				marca=sc.next();
				v1=new vehiculos(matricula, marca);
				vehiculosConcesionario.add(v1);
				System.out.println("Vehículo dado de alta");
				}
				
					break;
				case 5: System.out.println("Dime matrícula del vehículo: ");
				matricula=sc.next();
				for(vehiculos v2: vehiculosConcesionario) {
			    	if(v2.getMatrícula().equals(matricula)) {
			    		vehiculosConcesionario.remove(v2);
			    		System.out.println("Vehículo eliminado");
			    		break;
				    }else {
				    	System.out.println("Vehículo no eliminado, no se encuentra guardado");
				    }
			    }
			break;
			
				case 6:  System.out.println("Vehículos actuales guardados: ");
				for(vehiculos v2:vehiculosConcesionario) {
					System.out.println(v2.getMarca()+" " +"con matrícula "+v2.getMatrícula());
				}
				break;
			
				case 7: System.out.println("Salir");
				break;
				
			default:  System.out.println("Opción no válida");
				
			}
		}while (opcion!=7);

	}
		
	//Todos los métodos que se encuentre dentro de la clase principal tienen que llevar static
		public static void mostrarMenu() {
			System.out.println("Menú de opciones");
			System.out.println("1.- Dar de alta a un cliente");
			System.out.println("2.- Dar de baja a un cliente");
			System.out.println("3.- Mostrar todos los clientes guardados");
			System.out.println("4.- Dar de alta un vehículo");
			System.out.println("5.- Dar de baja un vehículo");
			System.out.println("6.- Mostrar todos los vehículos guardados");
			System.out.println("7.- Salir");
			}
	}	
