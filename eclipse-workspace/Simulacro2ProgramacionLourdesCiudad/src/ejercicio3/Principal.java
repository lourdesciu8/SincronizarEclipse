package ejercicio3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Pelicula> peliculasArray = new ArrayList<Pelicula>();
        
		//Se crean objetos de tipo Película y se añaden al ArrayList
		Pelicula p1=new Pelicula("Sin novedad en el frente", "Edward Berger", 7.2, 5.6, 8.3);
		Pelicula p2=new Pelicula("Los Fabelman", "Steven Spielberg", 7.3, 6.5, 7.8);
		
		peliculasArray.add(p1);
		peliculasArray.add(p2);
		
		//Se recorre el ArrayList con un foreach para mostrar los datos de las películas
        for (Pelicula item : peliculasArray) {
            System.out.println("Película: " + item.getTitulo() + ", Director: " + item.getDirector() + ", Puntuación Media: " + item.PuntuacionMedia());
        }
        
        /*Otra forma de mostrar los datos de las películas
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        */
        
        //Se leen los datos desde el propio fichero txt
        System.out.println("\nLeer películas desde el fichero: ");
        try {
            ArrayList<Pelicula> variable = Pelicula.leerPeliculas("peliculas.txt");
            for (Pelicula p : variable) {
                System.out.println("Película: " + p.getTitulo() + ", Director: " + p.getDirector() + ", Puntuación Media: " + p.PuntuacionMedia());
            }
        } catch (FileNotFoundException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
        	
        
		} catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }
	}

}
