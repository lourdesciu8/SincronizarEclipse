package model;

public class ProfesorModulo {
	private Profesor profesor;
	private Modulo modulo;
	
	public ProfesorModulo() {
	}
	
	public ProfesorModulo(Profesor profesor, Modulo modulo) {
		this.profesor = profesor;
		this.modulo = modulo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
}
