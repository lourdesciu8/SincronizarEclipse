import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class NotasMediasClase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Hacer una aplicación para mostrar la nota media de una clase, la nota más baja y la nota más alta.
		/*El usuario debe de indicar cuántas notas quiere introducir. Una vez introduzca todas las notas,
		 *la aplicación debe mostrar por pantalla la media de clase, la nota más baja y la más alta.
		 */
	
	    //Variables
	    Scanner sc = new Scanner(System.in);
	    int  cantidadNotas;
	    double nota;
	    double sumaNotas = 0;
        double notaMasBaja=Double.MAX_VALUE; //lo igualo al mayor nº de los posibles
        double notaMasAlta=Double.MIN_VALUE; //lo igualo al menor nº posible

        // Solicitar al usuario la cantidad de notas
        System.out.print("Ingrese la cantidad de notas: ");
        cantidadNotas = sc.nextInt();

        // Recoger las notas del usuario
        for (int i = 0; i < cantidadNotas; i++) {
            System.out.print("Ingrese la nota " + (i+1) + ":");
            nota = sc.nextDouble();
       
        // Operaciones
            sumaNotas=sumaNotas+ nota;
            notaMasBaja = Math.min(notaMasBaja, nota);
            notaMasAlta = Math.max(notaMasAlta, nota);
        
        }
        // Resultados
        double media = sumaNotas / cantidadNotas;
        System.out.printf("Nota media: %1.2f%n", media);
        System.out.println("Nota más baja: " + notaMasBaja);
        System.out.println("Nota más alta: " + notaMasAlta);
		}
	 }
