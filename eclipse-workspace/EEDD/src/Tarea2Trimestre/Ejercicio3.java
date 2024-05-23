package Tarea2Trimestre;

public class Ejercicio3 {
    //Variables
	private int numeroCaballos;
    private int numeroCarreras;
    private String nombreHipodromo;
    private int costoCompetencia = 50; 
    private int premioEconomico; 

    // Constructores
    public Ejercicio3(int numeroCarreras, int premioEconomico) {
		this.numeroCarreras = numeroCarreras;
		this.premioEconomico = premioEconomico;
	}


	
	public Ejercicio3(int numeroCaballos, int numeroCarreras, int costoCompetencia) {

		this.numeroCaballos = numeroCaballos;
		this.numeroCarreras = numeroCarreras;
		this.costoCompetencia = costoCompetencia;
	}


	// Método para calcular el número total de premios repartidos
    public int calcularTotalPremios() {
        
        return numeroCarreras*premioEconomico;
        
    }
    
 // Método para calcular la cantidad total cobrada por los caballos
    public int calcularTotalCobradoPorCaballos() {
        
        int cantidadCobrada= numeroCaballos * numeroCarreras * costoCompetencia;
         return cantidadCobrada;
    }
    
    
    
  
    
}

	
