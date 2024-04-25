package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* File: para representar archivos y directorios en el sistema de archivos
 * 		 Podemos crear, borrar, renombrar o comprobar.
 * 
 * FileReader y FileWriter: leer y escribir datos en archivos de texto, carácter a 
 * carácter.
 * 
 * BufferedReader y BufferedWriter: leer y escribir, pero se almacenan los datos en
 * un buffer antes de hacer las operaciones.
 * 
 * Scanner
 * 
 * PrintWriter: imprimir representaciones formateadas de objetos en un archivo de texto
 * 
 * StringBuilder: clase que se utiliza para crear cadena de caracteres. Con ella 
 * podemos modificar el contenido después de crearla, es más eficiente que la clase
 * String.
 * */

public class principal {

	public static void main(String[] args) {
		// Escribir en un archivo de texto
        escribirArchivo("archivo.txt", "Hola, este es un ejemplo de escritura en un archivo de texto desde Java.");

        // Leer desde un archivo de texto
        String contenido = leerArchivo("archivo.txt");
        System.out.println("Contenido del archivo:");
        System.out.println(contenido);
	}

	public static void escribirArchivo(String nombreArchivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contenido);
            System.out.println("Se ha escrito en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    //El método de lectura devuelve un String
	public static String leerArchivo(String nombreArchivo) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
        	String linea;
            while ((linea = reader.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return sb.toString();
    }
	
}



