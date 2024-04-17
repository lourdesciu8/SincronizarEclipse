package FormularioOK;

import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String nombre, apellido, dni, email;
		 int opcion;
		 boolean seguir=false;
		 usuario u = new usuario();
		 
		 do {
			 mostrarMenu();
	            opcion = sc.nextInt();       
	            sc.nextLine(); 
	            
	            switch (opcion) {
	                case 1:
	                	System.out.print("Ingrese el nombre:");
	                	nombre = sc.nextLine();
	                	u.setNombre(nombre);
	                    break;
	                case 2:
	                	System.out.print("Ingrese el apellido:");
	                	apellido = sc.nextLine();
	                	u.setApellido(apellido);
	                    break;
	                case 3:
	                	System.out.print("Ingrese el dni:");
	                	dni = sc.nextLine();
	                	u.setDni(dni);
	                    break;
	                case 4:
	                	System.out.print("Ingrese el email:");
	                	email = sc.nextLine();
	                	u.setEmail(email);
	                    break;
	                case 5:
					
					//Puede hacerse de 2 formas:
	                	if(u.getNombre()!=null && u.getApellido()!=null && u.getDni()!=null && u.getEmail()!=null) {
							seguir=false;
							System.out.println("Datos completados");
							break;
						}
						else seguir=true;	
		                System.out.println("Debe de introducir todos los datos");
	                	break;
	                	
	                default:
	                    System.out.println("Opción no válida, vuelva a intentarlo");
	            } 
			 
		                //if(nombre.isEmpty() && apellido.isEmpty() && dni.isEmpty() && email.isEmpty()) 
	                	
	               
		 }while(opcion !=5 || seguir);
		
	}
	 public static void mostrarMenu() {
	        System.out.println("Menú de opciones:");
	        System.out.println("1. Rellenar nombre");
	        System.out.println("2. Rellenar apellido");
	        System.out.println("3. Rellenar DNI");
	        System.out.println("4. Rellenar email");
	        System.out.println("5. Finalizar");
	    }
	
	}

