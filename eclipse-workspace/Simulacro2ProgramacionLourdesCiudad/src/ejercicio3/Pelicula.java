package ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pelicula {
	//Atributos
	protected String titulo;
    protected String director;
    protected double puntuacion1;
    protected double puntuacion2;
    protected double puntuacion3;
	
    //Constructor
    protected Pelicula(String titulo, String director, double puntuacion1, double puntuacion2, double puntuacion3) {
		this.titulo = titulo;
		this.director = director;
		this.puntuacion1 = puntuacion1;
		this.puntuacion2 = puntuacion2;
		this.puntuacion3 = puntuacion3;
	}

    
    //Getters 
    protected String getTitulo() {
		return titulo;
	}

	protected String getDirector() {
		return director;
	}

	protected double getPuntuacion1() {
		return puntuacion1;
	}

	protected double getPuntuacion2() {
		return puntuacion2;
	}

	protected double getPuntuacion3() {
		return puntuacion3;
	}
	
	protected double PuntuacionMedia() {
		return (puntuacion1 + puntuacion2 + puntuacion3) / 3;
	}
    
	public String toString() {
        return "Película: " +
               "título=" + titulo +
               ", director=" + director +
               ", puntuaciones=" + puntuacion1 + ", " + puntuacion2 + ", " + puntuacion3 +
               ", puntuación media=" + PuntuacionMedia();
    }
	
	public static ArrayList<Pelicula> leerPeliculas(String nombreFichero) throws IOException {
		ArrayList<Pelicula> peliculasArray = new ArrayList<Pelicula>();
		nombreFichero="peliculas.txt";
		FileReader fr=new FileReader(nombreFichero);
		BufferedReader br = new BufferedReader(fr);
		
		 String linea;
	        while ((linea = br.readLine()) != null) {
	            String elementos [] = linea.split(",");
	            
	            //Cada línea tiene cinco elementos separados por comas. Esos elementos son: Título, director, puntuación 1, 2 y 3.
	            if (elementos.length == 5) {
	                Pelicula p1 = new Pelicula(elementos[0], elementos[1], Double.parseDouble(elementos[2]), Double.parseDouble(elementos[3]), Double.parseDouble(elementos[4]));
	                peliculasArray.add(p1);
	            }
	        }
	        br.close();
		
		return peliculasArray;
    
	}
}