package ActividadEvaluableTrimestre3;

import java.util.Date;

public class Reserva {
	
	//Atributos
	protected Cliente cliente;
    protected Habitacion habitacion;
    protected Date fecha;

    
    //Constructor
    public Reserva(Cliente cliente, Habitacion habitacion, Date fecha) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fecha = fecha;
    }


   //Getters y Setters
    
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Habitacion getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
	
	public String toString() {
        return "Reserva para la habitación " + habitacion.numero + " en la fecha " + fecha + " por el cliente" +" " +cliente.getNombre();
    }
    
}
