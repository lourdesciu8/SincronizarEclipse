import java.util.Scanner;
public class ArrayUnidimensional3 {

	public static void main(String[] args) {
		// Crea un array de 10 posiciones de números con valores pedidos por teclado.Muestra por consola el indice y el valor al que corresponde.

		final int LONGITUD = 10;
		int arrayNum[]=new int[LONGITUD];
		// Rellenamos el array
		Scanner teclado = new Scanner(System.in);
		for(int i=0;i<arrayNum.length;i++){
		System.out.println("Introduce un número");
		arrayNum[i]=teclado.nextInt();
		}

		// Mostramos el array
		for(int i=0;i<arrayNum.length;i++){
		System.out.println("En el indice "+i+" esta el valor "+arrayNum[i]);
		}
	}

}
