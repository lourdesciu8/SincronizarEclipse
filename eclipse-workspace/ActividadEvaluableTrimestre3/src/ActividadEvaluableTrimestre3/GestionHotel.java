package ActividadEvaluableTrimestre3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionHotel {
	//Atributos
	protected ArrayList<Habitacion> habitaciones=new ArrayList<>();
    protected ArrayList<Reserva> reservas=new ArrayList<>();
    protected ArrayList<Administrador> administradores=new ArrayList<>();

    //Constructor
	public GestionHotel() {
	
	}

	// Métodos para la gestión de habitaciones
    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void eliminarHabitacion(Habitacion habitacion) {
        habitaciones.remove(habitacion);
    }

    public void modificarPrecio(Habitacion habitacion, double nuevoPrecio) {
        habitacion.setPrecioNoche(nuevoPrecio);
    }

    // Métodos para la gestión de reservas
    public void reservarHabitacion(Cliente cliente, Habitacion habitacion, Date fecha) {
        Reserva reserva = new Reserva(cliente, habitacion, fecha);
        reservas.add(reserva);
    }

    public List<Habitacion> habitacionesDisponibles(Date fecha) {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (!estaReservada(habitacion, fecha)) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    public List<Habitacion> habitacionesReservadas() {
        List<Habitacion> reservadas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            reservadas.add(reserva.getHabitacion());
        }
        return reservadas;
    }

    public List<Reserva> reservasCliente(String nombreCliente) {
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            Cliente cliente = reserva.getCliente();
            
            if (cliente != null && cliente.getNombre() != null && cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }

    private boolean estaReservada(Habitacion habitacion, Date fecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) && reserva.getFecha().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    // Métodos para la gestión de administradores
    public void agregarAdministrador(Administrador admin) {
        administradores.add(admin);
    }

    public void eliminarAdministrador(Administrador admin) {
        administradores.remove(admin);
    }


    // Otros métodos
    public void verHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }

    public void verReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
        } else {
            System.out.println("Reservas realizadas:");
        }
        
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
    
    public Habitacion buscarHabitacion(int numeroHabitacion) {
        for (Habitacion hab : habitaciones) {
            if (hab.getNumero() == numeroHabitacion) {
                return hab;
            }
        }
        return null; // Si no se encuentra la habitación
    }
    
}