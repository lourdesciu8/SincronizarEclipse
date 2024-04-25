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
    protected GestionHotel() {
	
	}

	// Métodos para la gestión de habitaciones
    protected void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    protected void eliminarHabitacion(Habitacion habitacion) {
        habitaciones.remove(habitacion);
    }

    protected void modificarPrecio(Habitacion habitacion, double nuevoPrecio) {
        habitacion.setPrecioNoche(nuevoPrecio);
    }

    // Métodos para la gestión de reservas
    protected void reservarHabitacion(Cliente cliente, Habitacion habitacion, Date fecha) {
        Reserva reserva = new Reserva(cliente, habitacion, fecha);
        reservas.add(reserva);
    }

    protected List<Habitacion> habitacionesDisponibles(Date fecha) {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (!estaReservada(habitacion, fecha)) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    protected List<Habitacion> habitacionesReservadas() {
        List<Habitacion> reservadas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            reservadas.add(reserva.getHabitacion());
        }
        return reservadas;
    }

    protected List<Reserva> reservasCliente(String nombreCliente) {
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            Cliente cliente = reserva.getCliente();
            
            if (cliente != null && cliente.getNombre() != null && cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }

    protected boolean estaReservada(Habitacion habitacion, Date fecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) && reserva.getFecha().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    // Métodos para la gestión de administradores
    protected void agregarAdministrador(Administrador admin) {
        administradores.add(admin);
    }

    protected void eliminarAdministrador(Administrador admin) {
        administradores.remove(admin);
    }


    // Otros métodos
    protected void verHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }

    protected void verReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
        } else {
            System.out.println("Reservas realizadas:");
        }
        
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
    
    protected Habitacion buscarHabitacion(int numeroHabitacion) {
        for (Habitacion hab : habitaciones) {
            if (hab.getNumero() == numeroHabitacion) {
                return hab;
            }
        }
        return null; // Si no se encuentra la habitación
    }
    
}