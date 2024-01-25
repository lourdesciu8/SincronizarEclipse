
public class ArrayMultidimensional1 {

	public static void main(String[] args) {
		
		//1. Crear una matriz de 3×3 con los números del 1 al 9. Mostrar por pantalla en forma de matriz.
		
		final int filas=3;
		final int columnas=3;
		int arrayBi [][] = new int [3][3];
		arrayBi [0][0] = 1;
		arrayBi [0][1] = 2;
		arrayBi [0][2] = 3;
		arrayBi [1][0] = 4;
		arrayBi [1][1] = 5;
		arrayBi [1][2] = 6;
		arrayBi [2][0] = 7;
		arrayBi [2][1] = 8;
		arrayBi [2][2] = 9;
		
		
		//Se recorren las filas
		for(int i=0; i<3;i++) {
			//Se recorren las columnas para cada fila
			for(int j=0; j<3;j++) {
				 System.out.print(arrayBi[i][j]+ " ");
			}
			System.out.println();
		}
		
	}

}
