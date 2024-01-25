import java.util.Scanner;

public class SueldoTrabajador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Elaborar un programa para calcular el sueldo de un trabajador, a partir de las horas trabajadas en la semana
		/*y la clase a la que pertenece:
		 *Trabajadores de clase “A”, se les paga 25 euros por hora.
		 *Trabajadores de clase “B”, se paga 20 euros por hora.
		 *Trabajadores de clase “C”, se les paga 15 euros por hora y 
		 *Trabajadores de clase “D”, 10 euros por hora.
		 *Ingresar el número de horas trabajadas, la clase a la que pertenece y mostrar el sueldo del trabajador.
		 *Una vez termina con un trabajador debe de volver al menú principal para seguir calculando los sueldos,
		 *a no ser que el usuario le diga que quiere cerrar.
		 */
		
		int horas, sueldo, clase, resultado;
		final int preciohoraA=25;
		final int preciohoraB=20;
		final int preciohoraC=15;
		final int preciohoraD=10;
		
		Scanner sc=new Scanner (System.in);
		
		while (true) {
		System.out.print("Introduce nº de horas trabajadas: ");
        horas=sc.nextInt();
        System.out.print("Introduce clase a la que pertenece el trabajador: ");
        System.out.println("\n1: Clase A \n2: Clase B \n3: Clase C \n4: Clase D");
        clase=sc.nextInt();
        
        if(clase<=0 || clase>=5) {
        	System.out.print("Salir");
        break;
        }
        
        
        switch (clase) {
        case 1:
        	resultado=horas*preciohoraA;
            System.out.println("El sueldo del trabajador es igual a " + resultado + " euros/semanales.");
            break;
        
        case 2:
        	resultado=horas*preciohoraB;
            System.out.println("El sueldo del trabajador es igual a " + resultado + " euros/semanales.");
            break;
            
        case 3:
        	resultado=horas*preciohoraC;
            System.out.println("El sueldo del trabajador es igual a " + resultado + " euros/semanales.");
            break;
            
        case 4:
        	resultado=horas*preciohoraD;
            System.out.println("El sueldo del trabajador es igual a " + resultado + " euros/semanales.");
            break;
        	
			}

		}
	}
}

