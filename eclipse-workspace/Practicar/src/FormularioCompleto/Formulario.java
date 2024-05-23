package FormularioCompleto;

import java.util.Scanner;

public class Formulario {

    public static void main(String[] args) {
    	Usuario u1=new Usuario();
    	Scanner sc = new Scanner(System.in);
    	String nombre=""; 
    	String apellidos="";
    	String email="";
    	String fechaNacimiento="";
		String dni="";
		String telefono ="";
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                	System.out.print("Ingrese el nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    apellidos = sc.nextLine();
                    
                    try {
                    	TipoDatoIncorrectoException.NombreIncorrecto(nombre);
                    	TipoDatoIncorrectoException.ApellidosIncorrecto(apellidos);
                    	u1.setNombre(nombre);
                        u1.setApellidos(apellidos);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " +e.getMessage());
                    }
                    
                    
                    break;
                case 2:
                	System.out.print("Ingrese el e-mail: ");
                    email = sc.nextLine();
                    try {
                    	EmailIncorrectoException.EmailIncorrecto(email);
                        u1.setEmail(email);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " +e.getMessage());
                    }
                
                    break;
                case 3:
                	System.out.print("Ingrese la fecha de nacimiento (dd/mm/yyyy): ");
                    fechaNacimiento = sc.nextLine();
                    try {
                        FormatoFechaNoValidoException.comprobarFecha(fechaNacimiento);
                        u1.setFechaNacimiento(fechaNacimiento);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " +e.getMessage());
                    }
                    break;
                case 4:
                	System.out.print("Ingrese el DNI: ");
                    dni = sc.nextLine();
                    try {
                        LongitudDNINoValidaException.comprobarLongitud(dni); //Comprueba la longitud del DNI
                        UltimoDigitoNoLetraException.ComprobarLetra(dni); //Comprueba que el último caracter sea una letra
                        NumeracionContieneLetrasException.NumeracionContieneLetras(dni); //Comprueba que los 8 primeros caracteres del DNI son solo números
                        u1.setDni(dni);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " +e.getMessage());
                    }
                    break;
                case 5:
                	System.out.print("Ingrese el número de teléfono móvil: ");
                    telefono = sc.nextLine();
                    try {
                        LongitudTelefonoNoValidaException.comprobarLongitud(telefono);
                        u1.setTelefonoMovil(telefono);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " +e.getMessage());
                    }
                    break;
                case 6:
                	if (datosCompletos(nombre, apellidos, email, fechaNacimiento, dni, telefono)){
            			System.out.println("Todos los datos han sido completados: ");
            			System.out.println(u1.toString());
            		}else {
            			System.out.println("Faltan datos por rellenar");
            			mostrarMenu();
            		}
            			
            			break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion!=6 || !datosCompletos(nombre, apellidos,email, fechaNacimiento, dni, telefono));

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Rellenar nombre y apellidos.");
        System.out.println("2. Rellenar e-mail.");
        System.out.println("3. Rellenar fecha de nacimiento (Formato: dd/mm/yyyy).");
        System.out.println("4. Rellenar DNI.");
        System.out.println("5. Rellenar número de teléfono móvil.");
        System.out.println("6. Finalizar.");
      
    }


    public static boolean datosCompletos(String nombre, String apellidos, String email, String fechaNacimiento , String dni, String telefono) {
		// Verifica si estos campos no están vacíos.
		boolean nombreCompleto=!nombre.isEmpty() && !apellidos.isEmpty();
		boolean emailCompleto=!email.isEmpty();
		boolean fechaNacimientoCompleta=!fechaNacimiento.isEmpty();
		boolean dniCompleto=!dni.isEmpty();
		boolean telefonoCompleto=!telefono.isEmpty();
		
		//Si alguno de los campos está vacío:
		if (!nombreCompleto) {
			System.out.println("Falta por rellenar el nombre y/o apellidos");
		}
		if (!emailCompleto) {
			System.out.println("Falta por rellenar el email");
		}
		if (!fechaNacimientoCompleta) {
			System.out.println("Falta por rellenar la fecha");
		}
		
		if (!dniCompleto) {
			System.out.println("Falta por rellenar el dni");
		}
		if (!telefonoCompleto) {
			System.out.println("Falta por rellenar el telefono");
		}
		
		return nombreCompleto && emailCompleto && fechaNacimientoCompleta && dniCompleto && telefonoCompleto ;
		
	}
}

