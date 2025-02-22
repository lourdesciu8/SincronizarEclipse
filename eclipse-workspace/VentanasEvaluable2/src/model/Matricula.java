package model;

public class Matricula {
	private Alumno alumno;
	private Modulo modulo;
	//contructor vacio
	public Matricula() {
	}
	//constructor completo
	public Matricula(Alumno alumno, Modulo modulo) {
		this.alumno = alumno;
		this.modulo = modulo;
		
		//getters setters
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

}
