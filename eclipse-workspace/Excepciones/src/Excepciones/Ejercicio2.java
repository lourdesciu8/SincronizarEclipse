package Excepciones;

public class Ejercicio2 {
	//Se crea un método para calcular la media de los arrays de enteros
	public static double calcularMedia(int array [] ) {
        if (array.length == 0) {
            throw new IllegalArgumentException("El array está vacío");
        }
        
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        double sumaTotal = (double) suma; // Convertir la suma a tipo double
        double media = sumaTotal / array.length; // Calcular la media dividiendo la suma total por la longitud del array
        return media; // Devolver la media calculada

	}
}
