package Ejercicio1;

import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc=new Scanner(System.in);
		String nombre="";
		String apellidos="";
		String dni=""; 
		int opcion;
		usuario u=new usuario();
		
		//Bucle do-while con un switch dentro para el menú de opciones
		do {
			mostrarMenu();
			opcion=sc.nextInt();
			sc.nextLine();
			
		switch (opcion) {
		case 1: System.out.println("Introduce el nombre del usuario: ");
			nombre=sc.nextLine();
			u.setNombre(nombre);;
			break;
		case 2: 
			System.out.println("Introduce los apellidos del usuario: ");
			apellidos=sc.nextLine();
			u.setApellidos(apellidos);;
			break;
		case 3: 
			System.out.println("Introduce dni de usuario: ");
			dni=sc.nextLine();
			
			//Estructura try-cath para controlar las excepciones 
			try {
				LongitudDNINoValidaException.ComprobarLongituddni(dni); //Comprueba que la longitus del dni es correcta
				UltimoDigitoNoLetraException.ComprobarLetradni(dni); //Comprueba que el último catacter es una letra
				u.setDni(dni);
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " +e.getMessage());
			}
			catch (Exception e) {
				System.out.println("Error: " +e.getMessage());
			}
			
			break;
		case 4: if (datosCompletos(nombre, apellidos, dni)) {
			System.out.println("Formulario relleno satisfactoriamente");
			System.out.println(u.toString());
		}else {
			System.out.println("Faltan algunos datos por rellenar");
			mostrarMenu();
		}
			
			break;
		
		default: System.out.println("Opción no válida");
			
		}

	}while (opcion!=4 || !datosCompletos(nombre, apellidos, dni));
	
	}
	
	public static void mostrarMenu() {
		System.out.println("Menú de opciones: \n"
				+ "1. Rellenar nombre \n"
				+ "2. Rellenar apellidos \n"
				+ "3. Rellenar dni \n"
				+ "4. Finalizar");
	}
	
	//Este método comprueba si todos los campos del formulario están rellenos.
	public static boolean datosCompletos(String nombre, String apellidos, String dni) {
		
		// Verifica si estos campos no están vacíos.
		boolean nombreCompleto=!nombre.isEmpty();
		boolean apellidosCompleto=!apellidos.isEmpty();
		boolean dniCompleto=!dni.isEmpty();
		
		//Si alguno de los campos está vacío:
		if (!nombreCompleto) {
			System.out.println("Falta por rellenar el nombre");
		}
		if (!apellidosCompleto) {
			System.out.println("Faltan por rellenar los apellidos");
		}
		if (!dniCompleto) {
			System.out.println("Falta por rellenar el dni");
		}
		
		return nombreCompleto && apellidosCompleto && dniCompleto  ;
		
	}
}