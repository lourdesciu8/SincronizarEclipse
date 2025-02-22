package model;

public class Nota {
	private int id;
	private double nota;
	private Alumno alumno;
	private Profesor profesor;
	private Modulo modulo;

	
	//constructor vacio
	public Nota() {
	}
	//constructor completo
	public Nota(int id, Alumno alumno, Profesor profesor, Modulo modulo, double nota) {
		this.id = id;
		this.alumno = alumno;
		this.profesor = profesor;
		this.modulo = modulo;
		this.nota = nota;
	}
	//getters setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
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
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
	
	

}
