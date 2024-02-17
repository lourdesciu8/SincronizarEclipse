package ActividadEvaluableTrimestre2;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.x500.X500Principal;


public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dni, nombre;
		int edad, opcion;
		boolean casado;
		double salario;
		
		int lineasDeCodigoPorHora;
		String lenguajeDominante;
		
		
		Programador p1;
		
		
		//Se crea 1 arraylist para guardar los datos que se vayan generando de Programador.
		ArrayList<Programador>ProgramadoresArray=new ArrayList<Programador>();
		

	    do {
	    	mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1: System.out.println("Dime dni del programador: ");
						dni=sc.next();
						
						if(!comprobarExisteProgramador(dni,ProgramadoresArray)) {
							darAltaProgramador(dni,ProgramadoresArray,sc);
						}
						
					break;
								
				case 2: System.out.println("Dime dni del programador: ");
						dni=sc.next();
						darBajaProgramador(dni,ProgramadoresArray);
					break;
					
				case 3:  System.out.println("Diga cuanto quiere aumentar el salario de un programador: ");
				Programador pr=new Programador(double PorcentajeAumento);
				System.out.println(pr.AumentarSalario);
				break;
						
				case 4: System.out.println("Salir");
				break;
				
			default:  System.out.println("Opción no válida");
				
			}
		}while (opcion!=4);

	}
		
	//Todos los métodos que se encuentre dentro de la clase principal tienen que llevar static
		public static void mostrarMenu() {
			System.out.println("Menú de opciones");
			System.out.println("1.- Dar de alta a un programador");
			System.out.println("2.- Dar de baja a un programador");
			System.out.println("3.- Aumentar salario de un programador"); 
			System.out.println("4.- Salir");
			}
		
		
		public static boolean comprobarExisteProgramador(String dni, ArrayList<Programador>ProgramadoresArray) {
			boolean existeprogramador=false;
			for(Programador p2: ProgramadoresArray) {
		    	if(p2.getDni().equals(dni)) {
					System.out.println("No se puede dar de alta. El programador ya está en la base de datos");
					existeprogramador=true;
					break;
				}
			}
			return existeprogramador;
		}
		
		
		public static void darAltaProgramador(String dni, ArrayList<Programador>ProgramadoresArray ,Scanner sc) {
			String nombre;
			int edad;
			boolean casado;
			double salario;
			//String apellidos;
			
			Programador p1;
			
				System.out.println("Dime el nombre: ");
				nombre=sc.next();
				System.out.println("Dime la edad (entre 18 y 45) : ");
				edad=sc.nextInt();
				System.out.println("Dime si está casado indicando true o false: ");
				casado=sc.nextBoolean();
				System.out.println("Dime el salario: ");
				salario=sc.nextDouble();
				
				//System.out.println("Dime los apellidos: ");
				//apellidos=sc.nextLine();
				//sc.nextLine();
				p1=new Programador(nombre, dni, edad, casado, salario);
				ProgramadoresArray.add(p1);
				System.out.println(p1.toString()+"se ha dado de alta");
			
		}
		
		
		public static void darBajaProgramador(String dni, ArrayList<Programador>ProgramadoresArray) {	
		
		for(Programador p2: ProgramadoresArray) {
	    	if(p2.getDni().equals(dni)) {
	    		ProgramadoresArray.remove(p2);
	    		System.out.println(p2.toString()+"ha sido eliminado");
	    		break;
		    }else {
		    	System.out.println("Programador no eliminado, no se encuentra guardado");
		    }
	    }
	}
		

}
