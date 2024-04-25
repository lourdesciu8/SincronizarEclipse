package BibiliotecaSimulacro;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Biblioteca biblio = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            
            
            switch (opcion) {
                case 1:
                    darAltaUsuario(biblio, sc);
                    break;
                case 2:
                    darAltaArticulo(biblio, sc);
                    break;
                case 3:
                    hacerPrestamo(biblio, sc);
                    break;
                case 4:
                    hacerDevolucion(biblio, sc);
                    break;
                case 5:
                    System.out.println("SALIR");
                    break;
                default:
                    System.out.println("Por favor, elige una opción válida.");
            }
        } while (opcion != 5);
       
    }
    
    public static void mostrarMenu() {
        System.out.println("Menú de opciones");
        System.out.println("1. Dar de alta usuario");
        System.out.println("2. Dar de alta artículo");
        System.out.println("3. Hacer préstamo");
        System.out.println("4. Hacer devolución");
        System.out.println("5. Salir");
  
    }
    
    public static void darAltaUsuario(Biblioteca biblio, Scanner sc) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = sc.nextLine();
        biblio.agregarUsuario(new Usuario(nombre));
        System.out.println("Usuario dado de alta correctamente.");
    }
    
    public static void darAltaArticulo(Biblioteca biblio, Scanner sc) {
        System.out.println("Seleccione el tipo de artículo:");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Película");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        
        switch (opcion) {
            case 1:
                darAltaLibro(biblio, sc);
                break;
            case 2:
                darAltaRevista(biblio, sc);
                break;
            case 3:
                darAltaPelicula(biblio, sc);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    public static void darAltaLibro(Biblioteca biblio, Scanner sc) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = sc.nextLine();
        System.out.print("Ingrese el año de publicación del libro: ");
        int anioPublicacion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        
        biblio.agregarArticulo(new Libro(titulo, autor, anioPublicacion));
        System.out.println("Libro dado de alta correctamente.");
    }
    
    public static void darAltaRevista(Biblioteca biblio, Scanner sc) {
        System.out.print("Ingrese el título de la revista: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el mes y año de la revista: ");
        String mesAnio = sc.nextLine();
        
		biblio.agregarArticulo(new Revista(titulo, mesAnio));
        System.out.println("Revista dada de alta correctamente.");
    }
    
    public static void darAltaPelicula(Biblioteca biblio, Scanner sc) {
        System.out.print("Ingrese el título de la película: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el director de la película: ");
        String director = sc.nextLine();
        System.out.print("Ingrese el año de publicación de la película: ");
        int anioPublicacion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        
        biblio.agregarArticulo(new Pelicula(titulo, director, anioPublicacion));
        System.out.println("Película dada de alta correctamente.");
    }
    
    public static void hacerPrestamo(Biblioteca biblio, Scanner sc) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = sc.nextLine();
        Usuario usuario = biblio.getUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        
        System.out.print("Ingrese el título del artículo: ");
        String tituloArticulo = sc.nextLine();
        Articulo articulo = biblio.getArticuloPorTitulo(tituloArticulo);
        if (articulo == null) {
            System.out.println("Artículo no encontrado.");
            return;
        }
        
        usuario.hacerPrestamo(articulo);
    }
    
    public static void hacerDevolucion(Biblioteca biblio, Scanner sc) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = sc.nextLine();
        Usuario usuario = biblio.getUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        
        System.out.print("Ingrese el título del artículo a devolver: ");
        String tituloArticulo = sc.nextLine();
        Articulo articulo = biblio.getArticuloPorTitulo(tituloArticulo);
        if (articulo == null) {
            System.out.println("Artículo no encontrado.");
            return;
        }
        
        usuario.devolverArticulo(articulo);
	}
}
