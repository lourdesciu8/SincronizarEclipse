package Ficheros;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class PrimosEscribir {

public static void main(String[] args) {
	
	// los números primos solo son divisibles por 1 y por ellos mismos.
	
		String nombreArchivo = "primos.txt";
		        try {
		            FileWriter fw = new FileWriter(nombreArchivo);
		            BufferedWriter bw = new BufferedWriter(fw);

		            for (int i = 2; i <= 500; i++) {
		                if (esPrimo(i)) {
		                    bw.write(":"+i+ "\n");
		                }
		            }

		            bw.close();
		            System.out.println("Han quedado guardados los números primos correspondientes en el archivo " + nombreArchivo);
		        } catch (IOException e) {
		            System.err.println("Error al escribir en " + nombreArchivo);
		            System.out.println("Error: " + e.getMessage());
		        }
		    }

		public static boolean esPrimo(int num) {
				if (num <= 1) {
		            return false;
		        }
				//Los números 0 y 1 no son primos.
		        for (int i = 2; i <num; i++) {
		            if (num % i == 0) {
		                return false;
		                //Quiere decir que no es primo
		            }
		        }
		        return true;
		      //Quiere decir que es primo
		    }
		}

	