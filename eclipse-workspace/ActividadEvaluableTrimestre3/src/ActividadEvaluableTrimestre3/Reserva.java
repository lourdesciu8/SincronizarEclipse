package ActividadEvaluableTrimestre3;

import java.util.Date;

public class Reserva {
	
	//Atributos
	protected Cliente cliente;
    protected Habitacion habitacion;
    protected Date fecha;

    
    //Constructor
    protected Reserva(Cliente cliente, Habitacion habitacion, Date fecha) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fecha = fecha;
    }


   //Getters y Setters
    
    protected Cliente getCliente() {
		return cliente;
	}


    protected void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


    protected Habitacion getHabitacion() {
		return habitacion;
	}


    protected void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}


    protected Date getFecha() {
		return fecha;
	}


    protected void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
	
	public String toString() {
        return "Reserva para la habitación " + habitacion.numero + " en la fecha " + fecha + " por el cliente" +" " +cliente.getNombre();
    }
    
}
