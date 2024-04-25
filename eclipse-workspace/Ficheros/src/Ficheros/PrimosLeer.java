package Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrimosLeer {

	public static void main(String[] args) {
		String nombreArchivo = "primos.txt";
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            int contador = 1;
            System.out.println("Números primos en el archivo " + nombreArchivo + ":");
            while ((linea = br.readLine()) != null) {
            	System.out.println(contador++ + linea);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer" + nombreArchivo + ": " + e.getMessage());
        }
	}

}
