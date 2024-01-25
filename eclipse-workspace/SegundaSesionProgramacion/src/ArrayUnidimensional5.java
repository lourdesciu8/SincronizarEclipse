
public class ArrayUnidimensional5 {

	public static void main(String[] args) {
		// Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100.
		/* Obtén la suma de todos ellos y la media.
		 */
			int arrayNum[] = new int[100];
			// Asignamos los valores a cada posición y aprovechamos el bucle para ir sumándolos
			int suma = 0;
			for (int i = 0; i < arrayNum.length; i++){
			arrayNum[i]=i+1;
			suma=suma+arrayNum[i];
			}
			// Calculamos la media
			double media = (double)suma/arrayNum.length; // Realizamos conversión explícita, tenemos que tener en cuenta los decimales de la media
			System.out.println("La suma de los primeros 100 números naturales es: " + suma);
			System.out.println("La media es: " + media);
		}

	}

