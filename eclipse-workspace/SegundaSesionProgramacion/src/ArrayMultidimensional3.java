import java.util.Scanner;

public class ArrayMultidimensional3 {

	public static void main(String[] args) {
		//  3. Crear dos matrices de n filas x n columnas y sumar sus valores, los resultados se deben almacenar en otra matriz.
		/*Los valores y el tamaño, serán insertados por el usuario. Mostrar las matrices originales y el resultado.
		 */

		int n; //nº de filas
		int c; //nº de columnas
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Indica número de filas (n)");
		n=sc.nextInt();
		System.out.println("Indica número de columnas (c)");
		c=sc.nextInt();
		
		//Se crean arrays
		int array1 [][] = new int [n][c];
		int array2 [][] = new int [n][c];
		int arrayResultado [][] = new int [n][c];
		
		//Se introducen valores para la primera matriz
		 System.out.println("Ingrese los valores para la primera matriz:");
		 for(int i = 0; i < array1.length; i++) {
	            for (int j = 0; j < array1.length; j++) {
	                System.out.print("Ingrese el valor para la posición ["+i+"]["+j+"]: ");
	                array1[i][j] = sc.nextInt();
	            }
	        }
	
		//Se introducen valores para la segunda matriz
		 System.out.println("Ingrese los valores para la segunda matriz:");
		 for(int i = 0; i < array2.length; i++) {
	            for (int j = 0; j < array2.length; j++) {
	                System.out.print("Ingrese el valor para la posición ["+i+"]["+j+"]: ");
	                array2[i][j] = sc.nextInt();
	            }
	        }
		 //Se suman las matrices y se muestra el resultado en una tercera matriz
		 for (int i = 0; i < array1.length; i++) {
	            for (int j = 0; j < array1.length; j++) {
	                arrayResultado[i][j] = array1[i][j] + array2[i][j];
	                System.out.println("La matriz resultante tiene como valor en la posición ["+i+"]["+j+"]: "+arrayResultado[i][j]);
	            }
			}
	    }
	}
