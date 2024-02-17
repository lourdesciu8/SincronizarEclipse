package ActividadEvaluableTrimestre2;

public class Empleado {
	
	//Atributos o propiedades
	protected String nombre, dni;
	protected int edad;
	protected boolean casado;
	protected double salario;
	
	
	//Constructores
	public Empleado() {

	}


	public Empleado(String nombre, String dni, int edad, boolean casado, double salario) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.casado = casado;
		this.salario = salario;
	}


	
	//Métodos getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public boolean isCasado() {
		return casado;
	}


	public void setCasado(boolean casado) {
		this.casado = casado;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	//Método que permita mostrar la clasificación según la edad 
	public String clasificacionPorEdad(int edad) {
        if (edad <= 21) {
            return "Principiante";
        } else if (edad >= 22 && edad <= 35) {
            return "Intermedio";
        } else {
            return "Senior";
        }
    }
	
	
	//Método que permita aumentar el salario en un porcentaje 
	public void AumentarSalario(double PorcentajeAumento) {
        if (PorcentajeAumento > 0) {
            double aumento = salario * (PorcentajeAumento / 100);
            salario =salario+ aumento;
            System.out.println("El salario ha sido aumentado en un " + PorcentajeAumento + "%. Por lo tanto, el nuevo salario es igual a" + salario);
        } else {
            System.out.println("El porcentaje indicado debe ser un número mayor a cero.");
        }
    }
	
	
	//Método toString. Imprimir los datos del empleado por pantalla. 
	public String toString() {
		return "El empleado con nombre" +" " +nombre +" ,"+"dni" +" "+dni +","+ "edad" +" " +edad+" "+","+ "siendo casado igual a" +" " +casado
				+" " +"y con un salario de" +" "+salario +" " ;
	}
	
	
}
