package AlumnoDNI;
import java.util.Scanner;

public class principalAlumno {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		//Pruebas
		/*Alumno a1 = new Alumno();
		Alumno a2 = new Alumno("lourdes", "ciudad", "12345678L");
		
		System.out.println("El nombre del alumno 1 es: " +a1.getNombre());
		System.out.println("El nombre del alumno 2 es: " +a2.getNombre());
		
		a1.setNombre("ana");
		System.out.println("El nombre del alumno 1 es: " +a1.getNombre());
		*/
		
		do {
        System.out.println("Menú de opciones");
        System.out.println("1. Dar de alta alumno");
        System.out.println("2. Dar de baja alumno");
        System.out.println("3. Modificar datos de alumno");
        System.out.println("4. Salir ");
        opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                // Dar de alta alumno
                System.out.print("Ingrese nombre del alumno: ");
                String nombre = scanner.next();
                System.out.print("Ingrese apellido del alumno: ");
                String apellido = scanner.next();
                System.out.print("Ingrese DNI del alumno: ");
                String dni = scanner.next();

                // Crear instancia de Alumno
                Alumno nuevoAlumno = new Alumno(nombre, apellido, dni);

                // Comprobar DNI
                if (nuevoAlumno.comprobarDNI()) {
                    System.out.println("Alumno dado de alta correctamente.");
                } else {
                    System.out.println("El DNI ingresado no es válido.");
                }
                break;

            case 2:
                // Dar de baja alumno
                // Implementa la lógica de baja de alumno aquí
                break;

            case 3:
                // Modificar datos de alumno
                // Implementa la lógica de modificación de datos aquí
                break;
                
            case 4:
            	System.out.println("Salir");
            	break;

            default:
                System.out.println("Opción inválida");
                break;
                
        	}
        }while(opcion!=4);
	}
}

		
	