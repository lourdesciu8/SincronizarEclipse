package Excepciones;

import java.io.IOException;

public class Ejercicio2Main {

	public static void main(String[] args) {
		try {
            
            int array1 [] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10};
            int array2 []= {0, 10, 20, 30, 40, 50};
            int array3 [] = {}; // Array vacío
            
            
            System.out.println("Media del array1: " + Ejercicio2.calcularMedia(array1));
            System.out.println("Media del array2: " + Ejercicio2.calcularMedia(array2));
            System.out.println("Media del array3: " + Ejercicio2.calcularMedia(array3));
        
		} catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
