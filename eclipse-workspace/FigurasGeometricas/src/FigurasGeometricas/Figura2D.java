package FigurasGeometricas;

public abstract class Figura2D implements FiguraGeometrica {
	//Atributo
	protected String nombre;

	//Constructor
	public Figura2D(String nombre) {
		this.nombre = nombre;
	}

	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Métodos
	public abstract double calcularPerimetro();
	
}
