import java.util.Scanner;

public class ArrayMultidimensional2 {

	public static void main(String[] args) {
		
		//2. Crear una matriz de 5 filas y n columnas (se pide al usuario). Rellenarlo con números aleatorios entre 0 y 10.
		
		Scanner sc=new Scanner(System.in);
		final int filas=5;
		int numcolumnas;
		
		//Pedir número de columnas
		System.out.println("Indica número de columnas");
		numcolumnas=sc.nextInt();
		
		//Se crea el array y se rellena con nº aleatorios entre 0 y 10.
		int arrayBi [][] = new int [5][numcolumnas];
		//Se recorren las filas
		for(int i=0; i<5;i++) {
			//Se recorren las columnas para cada fila
			for(int j=0; j<numcolumnas;j++) {
				 arrayBi[i][j]=(int)(Math.random()*11);
				 System.out.print(arrayBi[i][j]+ " ");
			}
			System.out.println();
		}

	}

}
