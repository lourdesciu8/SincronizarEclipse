public class Alumna extends Persona{
	protected String numExp;
	
	
	protected Alumna(String numExp) {
		super();
		this.numExp = numExp;
	}

	protected Alumna(String dni, String nombre, String numExp) {
		super(dni, nombre);
		this.numExp = numExp;
	}

	public String getNumExp() {
		return numExp;
	}

	public void setNumExp(String numExp) {
		this.numExp = numExp;
	}
	
	public String toString() {
		return super.toString()+" con numero expediente "+numExp;
	}
	
}
