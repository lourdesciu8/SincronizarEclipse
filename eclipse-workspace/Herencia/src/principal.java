
import java.util.ArrayList;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		String dni;
		int opcion;
		Scanner sc = new Scanner(System.in);
		ArrayList<Persona>listaPersonas=new ArrayList<Persona>();
		Persona p=new Persona();
		do {
			mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1: System.out.println("Dime tu dni: ");
						dni=sc.next();
						if(!existePersona(dni,listaPersonas)) {
							darAltaAlumna(dni,listaPersonas,sc,p);
						}
						else System.out.print("La alumna ya existe");
					break;
				case 2: System.out.println("Dime tu dni: ");
						dni=sc.next();
						if(!existePersona(dni,listaPersonas)) {
							darAltaProfesor(dni,listaPersonas,sc,p);
						}
						else System.out.print("El profesor ya existe");
					break;	
				case 3: System.out.println("Dime tu dni: ");
						dni=sc.next();
						if(existePersona(dni,listaPersonas)) {
							darBajaPersona(dni,listaPersonas);
						}
						else System.out.print("La alumna no existe");
					break;	
				case 4: System.out.println("Dime tu dni: ");
						dni=sc.next();
						if(existePersona(dni,listaPersonas)) {
							darBajaPersona(dni,listaPersonas);
						}
						else System.out.print("El profesor no existe");
					break;
				case 5: System.out.println("Dime tu dni: ");
						dni=sc.next();
						if(existePersona(dni,listaPersonas)) {
							mostrarSalario(dni,listaPersonas);
						}
						else System.out.print("El profesor no existe");
			break;
			}
		}while(opcion!=6);
		
	} // fin del main
	
	public static void mostrarMenu() {
		System.out.println("Menu de opciones");
		System.out.println("1.- Dar alta alumna");
		System.out.println("2.- Dar alta profesor");
		System.out.println("3.- Dar baja alumna");
		System.out.println("4.- Dar baja profesor");
		System.out.println("5.- Mostrar salario de un profesor");
		System.out.println("6.- Salir");
	}
	public static boolean existePersona(String dni,ArrayList<Persona>listaPersonas) {
		boolean existe=false;
		for(Persona per:listaPersonas) {
			if(per.getDni().equals(dni)) {
				existe=true;
				break;
			}
		}
		return existe;
	}
	public static void darAltaAlumna(String dni,ArrayList<Persona>listaPersonas,Scanner sc,Persona p) {
		System.out.println("Dime tu nombre: ");
		String nombre=sc.next();
		System.out.println("Dime tu expediente: ");
		String expe=sc.next();
		p = new Alumna(dni,nombre,expe);
		listaPersonas.add((Alumna)p);
	}
	public static void darAltaProfesor(String dni,ArrayList<Persona>listaPersonas,Scanner sc,Persona p) {
		System.out.println("Dime tu nombre: ");
		String nombre=sc.next();
		System.out.println("Dime tu salario: ");
		double salario=sc.nextDouble();
		p = new Profesor(dni,nombre,salario);
		listaPersonas.add((Profesor)p);
	}
	public static void darBajaPersona(String dni,ArrayList<Persona>listaPersonas) {
		for(Persona per:listaPersonas) {
			if(per.getDni().equals(dni)) {
				listaPersonas.remove(per);
				break;
			}
		}
	}
	public static void mostrarSalario(String dni,ArrayList<Persona>listaPersonas) {
		for(Persona per:listaPersonas) {
			if (per instanceof Profesor) {
				if(per.getDni().equals(dni)) {
					System.out.println(per.toString());
				}
			}
		}
	}
}
