import java.util.Scanner;
public class ArrayUnidimensional4 {

	public static void main(String[] args) {
		// Crea un array de números donde le indicamos por teclado el tamaño del array,
		/*rellenaremos el array con números aleatorios entre 0 y 9,
		* al final muestra por pantalla el valor de cada posición y la suma de todos los valores.
		*/
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el tamaño del array: ");
		final int LONGITUD = teclado.nextInt();
		int arrayNum[] = new int[LONGITUD];
		
		// Otra forma de declarar el array:
		// int arrayNum[] = new int[teclado.nextInt()];
		
		for(int i=0;i<arrayNum.length;i++){
		// Generamos un número aleatorio entre 0 y 9
		// Math.floor(Math.random()*(N-M+1)+M); // Valores entre N y M ambos incluidos. Lo hacemos en dos pasos:
		double numAleatorio = Math.random()*(0-9+1)+9;
		double numAleatorioInt = Math.floor(numAleatorio);
		arrayNum[i]=((int) numAleatorioInt); // Math.floor nos devuelve un double, hacemos conversión explícita a int
		}
		
		// Mostramos el contenido del array a la vez que sumamos todos los valores (aprovechamos el mismo bucle for)
		int suma = 0;
		for(int i=0;i<arrayNum.length;i++){
		suma=suma+arrayNum[i];
		System.out.println("En el indice "+i+" esta el valor "+arrayNum[i]);
		}
		
		// Mostramos la suma de los valores del array
		System.out.println("La suma de los valores del array es: " + suma);
		}

	}
