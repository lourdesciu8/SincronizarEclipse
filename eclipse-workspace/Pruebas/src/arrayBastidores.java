

import java.util.Scanner;

//Guardar en un array los números de bastidores de los coches que entran en un taller para su  reparación.
/* 1.- Array cuando se crea null
 * 2.- ¿Cómo termino la ejecución de un bucle?
 * */

public class arrayBastidores {

	public static void main(String[] args) {
		String bastidores [] = new String [100];
		String bastidor;
		Scanner sc = new Scanner (System.in);
		
		//Pido un número de bastidor para guardar
		
		System.out.print("Dime el numero de bastidor: ");
		bastidor=sc.next();
		for(int i=0;i<bastidores.length;i++) {
			if(bastidores[i]==null) {
				bastidores[i]=bastidor;
				System.out.println("Bastidor guardado correctamente");
				i=bastidores.length;//Poner el primer valor que no se cumple en la condición del bucle for
				//break;
			}
		}
		
		System.out.println("Dime el numero de bastidor: ");
		bastidor=sc.next();
		for(int i=0;i<bastidores.length;i++) {
			if(bastidores[i]!=null) {
				if(bastidores[i].equals(bastidor)) {
					bastidores[i]=null;
					System.out.print("Bastidor eliminado correctamente");
					i=bastidores.length;//Poner el primer valor que no se cumple en la condición del bucle for
					//break;
				}	
			}
				
		}
	}
		
		
		

	}

