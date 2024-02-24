package Tarea2Trimestre;

public class Ejercicio2 {
	 // Atributos
    private int numeroAlumnos;
    private int numeroAsignaturas;
    private String nombreColegio;
    private double costoPorAsignatura = 75.0;

    // Constructor
    public Ejercicio2(int numeroAlumnos, int numeroAsignaturas, String nombreColegio, double costoPorAsignatura) {
	
		this.numeroAlumnos = numeroAlumnos;
		this.numeroAsignaturas = numeroAsignaturas;
		this.nombreColegio = nombreColegio;
		this.costoPorAsignatura = costoPorAsignatura;
	}
    
    
    
    public Ejercicio2(int numeroAlumnos, int numeroAsignaturas, double costoPorAsignatura) {
		
		this.numeroAlumnos = numeroAlumnos;
		this.numeroAsignaturas = numeroAsignaturas;
		this.costoPorAsignatura = costoPorAsignatura;
	}



	// Métodos getters y setters 
    public String getNombreColegio() {
        return nombreColegio;
    }


	public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    
    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public int getNumeroAsignaturas() {
        return numeroAsignaturas;
    }

    public void setNumeroAsignaturas(int numeroAsignaturas) {
        this.numeroAsignaturas = numeroAsignaturas;
    }

    // Método para calcular la cantidad total cobrada por el colegio
    public double calcularTotalCobrado( int numeroAlumnos, int numeroAsignaturas,double costoPorAsignatura) {
       
        double totalCobrado = numeroAlumnos * numeroAsignaturas * costoPorAsignatura;
        return totalCobrado;
    }

}
	