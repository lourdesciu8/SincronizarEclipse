package ejercicioFicherosUsuarios;

import java.util.Scanner;

import java.util.Scanner;

public class principal {
    
    public static void main(String[] args) {
        // Ejemplo de uso
        String archivo = "usuarios.txt", usuario, pass;
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        gestionFichero gf = new gestionFichero();
        do {
            MostrarMenu();
            opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.println("Usuario:");
                    usuario = sc.next();
                    System.out.println("Contraseña:");
                    pass = sc.next();
                    gf.insertarUsuario(usuario, pass, archivo);
                    break;
                case 2:
                    System.out.println("Usuario:");
                    usuario = sc.next();
                    System.out.println("Contraseña:");
                    pass = sc.next();
                    if(gf.buscarUsuario(usuario, pass, archivo)) {
                        System.out.println("Usuario encontrado");
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Usuario:");
                    usuario = sc.next();
                    System.out.println("Contraseña:");
                    pass = sc.next();
                    gf.borrarUsuario(usuario, pass, archivo);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 4);
    }
    
    public static void MostrarMenu() {
        System.out.println("Menú de opciones");
        System.out.println("1.- Insertar usuario");
        System.out.println("2.- Buscar usuario");
        System.out.println("3.- Borrar usuario");
        System.out.println("4.- Salir");
    }
}
