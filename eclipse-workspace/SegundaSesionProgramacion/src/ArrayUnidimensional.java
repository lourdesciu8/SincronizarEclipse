import java.util.Scanner;

import javax.lang.model.element.Element;

public class ArrayUnidimensional {

	public static void main(String[] args) {
		// 1.- Programa Java que guarda en un array 10 números enteros que se leen por teclado. 
		/*A continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros.
		 */
		
		//Variables
		Scanner sc=new Scanner(System.in);
		int nombreArray []= new int [10];
		
		//Guardar 10 números enteros en el array
		for(int i=0;i<nombreArray.length;i++) {
			System.out.println("Dime un número");
			nombreArray [i]=sc.nextInt();
		}
		
		//Recorrer array y contar cuantos nº positivos, negativos o ceros hay. (Utilizando un for each)
		 int positivos = 0;
	     int negativos = 0;
	     int ceros = 0;

	        for (int numero : nombreArray) {
	            if (numero > 0) {
	                positivos++;
	            } else if (numero < 0) {
	                negativos++;
	            } else {
	                ceros++;
	            }
	        }
	        System.out.println("Total de números positivos: " + positivos);
	        System.out.println("Total de números negativos: " + negativos);
	        System.out.println("Total de ceros: " + ceros);
	}
}
		
		//Recorrer el array y mostrar el contenido de cada posición
		//System.out.println("Contenido en la posición " +i+ ": " +nombreArray[i]);
		
		//Recorrer array y contar números positivos, negativos y ceros (Otra forma utilizando un for)
			//int positivos = 0;
			//int negativos = 0;
			//int ceros = 0;		

		/*for(int i=0;i<nombreArray.length;i++) {
			
			if(nombreArray[i]>0) {
				positivos++;
					
				}else if (nombreArray[i]<0) {
				negativos++;	
				}
					
				else {
					ceros++;
					
			System.out.println("Total de números positivos: " + positivos);
        	System.out.println("Total de números negativos: " + negativos);
        	System.out.println("Total de ceros: " + ceros);
		}
	}
		*/
		

