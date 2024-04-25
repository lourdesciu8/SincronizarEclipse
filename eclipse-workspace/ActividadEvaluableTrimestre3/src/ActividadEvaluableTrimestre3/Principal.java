package ActividadEvaluableTrimestre3;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		
		        GestionHotel hotel = new GestionHotel();
		        Scanner sc = new Scanner(System.in);

		        // Se crean algunas habitaciones
		        Habitacion habitacion1 = new Habitacion(123, "Doble", 70.0);
		        Habitacion habitacion2 = new Habitacion(202, "Individual", 45.0);
		        Habitacion habitacion3 = new Habitacion(344, "Familiar", 100.0);

		        // Agregar las habitaciones al sistema
		        hotel.agregarHabitacion(habitacion1);
		        hotel.agregarHabitacion(habitacion2);
		        hotel.agregarHabitacion(habitacion3);
		        
		        int opcion;
		        do {
		            mostrarMenu();
		            
		            opcion = sc.nextInt();
		            sc.nextLine(); 

		            switch (opcion) {
		                case 1:
		                	HabitacionesDisponibles(hotel);
		                    break;
		                case 2:
		                	RealizarReserva(sc, hotel);
		                    break;
		                case 3:
		                	ReservasRealizadas(hotel);
		                    break;
		                case 4:
		                	ReservasCliente(sc,hotel);
		                    break;
		                case 5:
		                    System.out.println("Salir");
		                    break;
		                default:
		                    System.out.println("Por favor, seleccione una opción válida.");
		            }
		        } while (opcion != 5);
	
	}
		       public static void mostrarMenu(){
		        	
		        	System.out.println("Menú de opciones");
		            System.out.println("1. Ver habitaciones disponibles");
		            System.out.println("2. Realizar reserva");
		            System.out.println("3. Ver reservas realizadas");
		            System.out.println("4. Ver reservas de un cliente en concreto");
		            System.out.println("5. Salir");
		  }
		       
		      public static void HabitacionesDisponibles(GestionHotel hotel) {
		    	  System.out.println("Habitaciones disponibles:");
                  List<Habitacion> habitacionesDisponibles = hotel.habitacionesDisponibles(new Date());
                  for (Habitacion habitacion : habitacionesDisponibles) {
                      System.out.println(habitacion);
                  }
		      }
		      
		      public static void RealizarReserva(Scanner sc, GestionHotel hotel) {
		    	    System.out.println("Realizar reserva:");
		    	    System.out.print("Ingrese su nombre: ");
		    	    String nombre = sc.nextLine();
		    	    System.out.print("Ingrese su email: ");
		    	    String email = sc.nextLine();
		    	    System.out.print("Ingrese su contraseña: ");
		    	    String password = sc.nextLine();
		    	    Cliente nuevoCliente = new Cliente(nombre, email, password);

		    	    try {
		    	        System.out.println("Buscar habitación:");
		    	        System.out.print("Ingrese el número de habitación: ");
		    	        int numeroHabitacion = Integer.parseInt(sc.nextLine()); // Modificación para capturar NumberFormatException
		    	        Habitacion habitacionSeleccionada = hotel.buscarHabitacion(numeroHabitacion);
		    	        if (habitacionSeleccionada != null) {
		    	            // Verificar el nombre del cliente
		    	            System.out.println("Cliente: " + nuevoCliente.getNombre());
		    	            hotel.reservarHabitacion(nuevoCliente, habitacionSeleccionada, new Date());
		    	            System.out.println("Reserva realizada con éxito.");
		    	        } else {
		    	            System.out.println("La habitación seleccionada no está disponible.");
		    	        }
		    	    } catch (NumberFormatException e) {
		    	        System.out.println("Error: el número de habitación debe ser un valor numérico.");
		    	    }
		    	}

		      
		      public static void ReservasRealizadas(GestionHotel hotel) {
                  hotel.verReservas();
		      }
		      
		      public static void ReservasCliente(Scanner sc, GestionHotel hotel) {
		    	  System.out.print("Introduzca el nombre del cliente: ");
                  String nombreClienteConsulta = sc.nextLine();
                  List<Reserva> reservasCliente = hotel.reservasCliente(nombreClienteConsulta);
                  if (reservasCliente.isEmpty()) {
                      System.out.println("El cliente no tiene reservas.");
                  } else {
                      System.out.println("Reservas del cliente " + nombreClienteConsulta + ":");
                      for (Reserva reserva : reservasCliente) {
                          System.out.println(reserva);
                      }
                  }
		      }
		        
	}
	

