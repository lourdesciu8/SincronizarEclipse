
public class Profesor extends Persona{
	protected double salario;

	protected Profesor(String dni, String nombre, double salario) {
		super(dni, nombre);
		this.salario = salario;
	}

	protected double getSalario() {
		return salario;
	}

	protected void setSalario(double salario) {
		this.salario = salario;
	}
	public String toString() {
		return super.toString()+" con un salario de "+salario;
	}
		
	
}
