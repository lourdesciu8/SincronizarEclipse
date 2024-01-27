package ejemploMetodos;

import java.util.Scanner;

public class principalAlumno {

	public static void main(String[] args) {
		String nombre, apellido, DNI;
		Scanner sc=new Scanner(System.in);
		
		Alumno a1 = new Alumno();
		Alumno a2 = new Alumno("lourdes", "ciudad", "12345678L");
		
		System.out.println("El nombre del alumno 1 es: " +a1.getNombre());
		System.out.println("El nombre del alumno 2 es: " +a2.getNombre());
		
		a1.setNombre("ana");
		System.out.println("El nombre del alumno 1 es: " +a1.getNombre());
	}

}
