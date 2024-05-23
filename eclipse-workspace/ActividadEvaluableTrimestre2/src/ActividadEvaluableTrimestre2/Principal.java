package ActividadEvaluableTrimestre2;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.x500.X500Principal;


public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dni;
		int opcion;
		double salario, PorcentajeAumento;
		
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
						sc.nextLine();
						
						if(!comprobarExisteProgramador(dni,ProgramadoresArray)) {
							darAltaProgramador(dni,ProgramadoresArray,sc);
						}
						
					break;
								
				case 2: System.out.println("Dime dni del programador: ");
						dni=sc.next();
						darBajaProgramador(dni,ProgramadoresArray);
					break;
					
				case 3: System.out.println("Dime dni del programador: ");
						dni = sc.next();
						sc.nextLine();
						
						aumentarSalarioProgramador(dni,ProgramadoresArray,sc);
						
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
					System.out.println("El programador ya se encuentra en la base de datos");
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

			Programador p1;
			
				System.out.println("Dime el nombre y apellido: ");
				nombre=sc.nextLine();
				do {
				System.out.println("Dime la edad (debe estar entre 18 y 45) : ");
				edad=sc.nextInt();
				}while(edad<18 || edad>45);
				System.out.println("Dime si está casado indicando true o false: ");
				casado=sc.nextBoolean();
				System.out.println("Dime el salario: ");
				salario=sc.nextDouble();
				
				p1=new Programador(nombre, dni, edad, casado, salario);
				ProgramadoresArray.add(p1);
				System.out.println(p1.toString()+ " se ha dado de alta");
			
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
		
		public static void aumentarSalarioProgramador (String dni,ArrayList<Programador>ProgramadoresArray,Scanner sc) {
			double PorcentajeAumento;
			
			//Si el programador existe en la base de datos, se procede a calcular el aumento de salario con el método AumentarSalario
			if (comprobarExisteProgramador(dni, ProgramadoresArray)) {
	        System.out.println("Diga cuanto quiere aumentar el salario del programador: ");
	        PorcentajeAumento = sc.nextDouble();
	      
	        boolean encontrado = false;
	        for (int i = 0; i < ProgramadoresArray.size(); i++) {
	            Programador p = ProgramadoresArray.get(i);
	            if (p.getDni().equals(dni)) {
	                p.AumentarSalario(p.getSalario(), PorcentajeAumento);
	                encontrado = true;
	                break;
	            }
	        }
	    //if encontrado=false;   
	    }else {
	        System.out.println("El programador no se encuentra en la base de datos y no se puede proceder al aumento de salario");
	    }
			
		}
		
}
