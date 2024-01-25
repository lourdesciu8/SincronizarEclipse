import java.util.Scanner;

/*Guardar en un array las notas de los alumnos de clase. Indicar el número de aprobados y suspensos*/

public class arrayAprobados {

	public static void main(String[] args) {
		int notas, aprobados=0, suspensos=0;
		double arrayNotas [];
		Scanner sc = new Scanner (System.in);
		
		System.out.print("¿Cuantas notas vas a introducir? ");
		notas=sc.nextInt();
		arrayNotas = new double[notas];
		
		//Preguntar las notas y guardarlas en mi array
		for(int i=0; i<arrayNotas.length; i++) {
			System.out.print("Dime la nota: ");
			arrayNotas[i]=sc.nextDouble();
		}
		
		//Recorrer el array para ver las notas y saber si esta suspenso o aprobado
		for(int i=0; i<arrayNotas.length; i++) {
			if(arrayNotas[i]<5){
				suspensos++;
			} else aprobados++;	
		}
		
		System.out.println("El numero de suspensos es: "+suspensos);
		System.out.println("El numero de aprobados es: "+aprobados);
	}

}
