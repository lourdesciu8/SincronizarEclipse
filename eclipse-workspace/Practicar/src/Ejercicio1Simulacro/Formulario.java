package Ejercicio1Simulacro;

import java.io.IOException;
import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		String nombre=""; 
		String contraseña="";
		String dni="";
		usuario u1=new usuario();
		
		do {
			mostrarMenu();
			opcion=sc.nextInt();
			sc.nextLine();
			
		switch (opcion) {
		case 1: System.out.println("Introduce nombre de usuario");
			nombre=sc.nextLine();
			u1.setNombre(nombre);;
			break;
		case 2: 
			System.out.println("Introduce contraseña");
			contraseña=sc.nextLine();
			u1.setContraseña(contraseña);;
			break;
		case 3: 
			System.out.println("Introduce dni de usuario");
			dni=sc.nextLine();
			try {
				LongitudDNINoValidaException.ComprobarLongitud(dni); 
				UltimoDigitoNoLetraException.ComprobarLetra(dni);
				u1.setDni(dni);
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " +e.getMessage());
			}
			
			break;
		case 4: if (datosCompletos(nombre, contraseña, dni)) {
			System.out.println("Todos los datos han sido completados");
			System.out.println(u1.toString());
		}else {
			System.out.println("Faltan datos por rellenar");
			mostrarMenu();
		}
			
			break;
		
		default: System.out.println("Opción no válida, inténtelo de nuevo");
			
		}

	}while (opcion!=4 || !datosCompletos(nombre, contraseña, dni));
	
	}
	
	public static void mostrarMenu() {
		System.out.println("Menú de opciones: \n"
				+ "1. Rellenar usuario \n"
				+ "2. Rellenar contraseña \n"
				+ "3. Rellenar dni \n"
				+ "4. Finalizar");
	}
	
	public static boolean datosCompletos(String nombre, String contraseña, String dni) {
		// Verifica si estos campos no están vacíos.
		boolean nombreCompleto=!nombre.isEmpty();
		boolean contraseñaCompleta=!contraseña.isEmpty();
		boolean dniCompleto=!dni.isEmpty();
		
		//Si alguno de los campos está vacío:
		if (!nombreCompleto) {
			System.out.println("Falta por rellenar el nombre");
		}
		if (!contraseñaCompleta) {
			System.out.println("Falta por rellenar la contraseña");
		}
		if (!dniCompleto) {
			System.out.println("Falta por rellenar el dni");
		}
		
		return nombreCompleto && contraseñaCompleta && dniCompleto  ;
		
	}
}
