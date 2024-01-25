import java.time.Year;
import java.util.Scanner;

import javax.lang.model.element.Element;

public class Array_DNI {

	public static void main(String[] args) {
		// Crea una aplicación donde, dado un DNI SÓLO NUMÉRICO, busque en un array de caracteres la posición que corresponda y devuelva su letra. 
		/*Para calcular la letra, se debe tomar el resto de dividir nuestro número de DNI entre 23. El resultado debe estar por tanto entre 0 y 22.
		 */

		//Variables
		int dni;
		String numdni, letradni;
		final int num=23;
		int resto; 
		Scanner sc=new Scanner(System.in);
		String array [] = new String[23];
		
		
		//Rellenar valores de array
		//char array []= {'T','R', 'W', 'A', 'G'};  De forma simplificada
		
		array [0]="T";
		array [1]="R";
		array [2]="W";
		array [3]="A";
		array [4]="G";
		array [5]="M";
		array [6]="Y";
		array [7]="F";
		array [8]="P";
		array [9]="D";
		array [10]="X";
		array [11]="B";
		array [12]="N";
		array [13]="J";
		array [14]="Z";
		array [15]="S";
		array [16]="Q";
		array [17]="V";
		array [18]="H";
		array [19]="L";
		array [20]="C";
		array [21]="K";
		array [22]="E";
		
		//Recorrer todos los valores almacenados en la matriz, e imprimirlos en consola.
				/*for(int i=0;i<23;i++) {
					System.out.println("Valor en la posición " + i + " = " + array[i]);
				}
		*/
		
		//Pide al usuario DNI sin letra por teclado
		System.out.println("Introduce DNI sin la letra : ");
		dni=sc.nextInt();
		
		//Calcular el resto
        resto=(dni%num);
        
        //Resultados
        System.out.println("Al dividir el número del DNI entre 23, el resto de la operación es igual a " + resto);
        System.out.println("Por tanto, la letra del DNI que corresponde es " +array[resto]);
        System.out.println("El dni con letra es: " +dni+array[resto]);
		
        //Extraer solo los números o solo la letra del DNI
        /*numdni=dni.substring(0, 8);
		*letradni=dni.substring(8);
		*System.out.println("El dni con letra es: " +numdni+letradni);
		*/
	}

}
