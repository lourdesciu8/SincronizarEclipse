package ActividadEvaluableTrimestre2;

import java.time.Year;

public class Programador extends Empleado {

	//Atributos o propiedades
	protected int lineasDeCodigoPorHora;
	protected String lenguajeDominante;
	
	
	//Constructores
	public Programador() {
		super();
	}


	public Programador(double salario, double PorcentajeAumento) {
		super(salario, PorcentajeAumento);
	}



	public Programador(int lineasDeCodigoPorHora, String lenguajeDominante) {
		super();
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}

	

	public Programador(String nombre, String dni, int edad, boolean casado, double salario) {
		super(nombre, dni, edad, casado, salario);
	}


	public Programador(String nombre, String dni, int edad, boolean casado, double salario, int lineasDeCodigoPorHora,
			String lenguajeDominante) {
		super(nombre, dni, edad, casado, salario);
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}

	
	//Métodos getters y setters
	public int getLineasDeCodigoPorHora() {
		return lineasDeCodigoPorHora;
	}


	public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
	}


	public String getLenguajeDominante() {
		return lenguajeDominante;
	}


	public void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}
	
	//Método toString
	public String toString() {
		return "El programador con nombre" +" " +nombre +" ,"+"dni" +" "+dni +","+ "edad" +" " +edad+" "+","+ "siendo casado igual a" +" " +casado
				+" " +"y con un salario de" +" "+salario + " euros" ;
	}
	
	//Método que permita aumentar el salario en un porcentaje 
		public void AumentarSalario(double salario, double PorcentajeAumento) {
	            double aumento = salario * (PorcentajeAumento / 100);
	            salario =salario+ aumento;
	            System.out.println("El salario del programador ha sido aumentado en un " + PorcentajeAumento + "%. Por lo tanto,"
	            		+ " el nuevo salario es igual a " + salario +" " +"euros");
	    }
}
