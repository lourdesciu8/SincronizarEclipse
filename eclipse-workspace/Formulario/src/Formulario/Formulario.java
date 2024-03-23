package Formulario;

import java.util.Scanner;

public class Formulario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String apellido = "";
        String dni = "";
        String email = "";

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();       
            sc.nextLine(); 
            
            switch (opcion) {
                case 1:
                	System.out.print("Ingrese el nombre:");
                	nombre = sc.nextLine();
                    break;
                case 2:
                	System.out.print("Ingrese el apellido:");
                	apellido = sc.nextLine();
                    break;
                case 3:
                	System.out.print("Ingrese el dni:");
                	dni = sc.nextLine();
                    break;
                case 4:
                	System.out.print("Ingrese el email:");
                	email = sc.nextLine();
                    break;
                case 5:
                    if (datosCompletos(nombre, apellido, dni, email)) {
                        System.out.println("Datos completados");
                    } else {
                        System.out.println("Faltan datos por rellenar.");
                        opcion = 0; // Volver al menú
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Rellenar nombre");
        System.out.println("2. Rellenar apellido");
        System.out.println("3. Rellenar DNI");
        System.out.println("4. Rellenar email");
        System.out.println("5. Finalizar");
    }


    public static boolean datosCompletos(String nombre, String apellido, String dni, String email) {
        // Verifica si el nombre no está vacío.
        boolean nombreCompleto = !nombre.isEmpty();
        
        boolean apellidoCompleto = !apellido.isEmpty();
        
        boolean dniCompleto = !dni.isEmpty();
        
        boolean emailCompleto = !email.isEmpty();

        // Si el nombre está vacío:
        if (!nombreCompleto) {
            System.out.println("Falta rellenar el nombre.");
        }
    
        if (!apellidoCompleto) {
            System.out.println("Falta rellenar el apellido.");
        }
        
        if (!dniCompleto) {
            System.out.println("Falta rellenar el DNI.");
        }
        
        if (!emailCompleto) {
            System.out.println("Falta rellenar el email.");
        }

        // Retorna true si todos los campos están completos, de lo contrario, retorna false.
        return nombreCompleto && apellidoCompleto && dniCompleto && emailCompleto;
    }


}
