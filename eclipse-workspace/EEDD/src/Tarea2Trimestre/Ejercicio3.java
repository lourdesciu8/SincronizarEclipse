package Tarea2Trimestre;

public class Ejercicio3 {
    private int numeroCaballos;
    private int numeroCarreras;
    private String nombreHipodromo;
    private int costoCompetencia = 50; 
    private int premioEconomico; 

    // Constructor
    
    
    public Ejercicio3(int numeroCaballos, int numeroCarreras, String nombreHipodromo) {
        this.numeroCaballos = numeroCaballos;
        this.numeroCarreras = numeroCarreras;
        this.nombreHipodromo = nombreHipodromo;
    }

    public Ejercicio3(int numeroCarreras, int premioEconomico) {
		this.numeroCarreras = numeroCarreras;
		this.premioEconomico = premioEconomico;
	}

	public Ejercicio3(int numeroCaballos, int numeroCarreras, String nombreHipodromo, int costoCompetencia,
			int premioEconomico) {
		
		this.numeroCaballos = numeroCaballos;
		this.numeroCarreras = numeroCarreras;
		this.nombreHipodromo = nombreHipodromo;
		this.costoCompetencia = costoCompetencia;
		this.premioEconomico = premioEconomico;
	}
	
	public Ejercicio3(int numeroCaballos, int numeroCarreras, int costoCompetencia) {

		this.numeroCaballos = numeroCaballos;
		this.numeroCarreras = numeroCarreras;
		this.costoCompetencia = costoCompetencia;
	}

	// Métodos getters y setters
    public int getNumeroCaballos() {
		return numeroCaballos;
	}

	public void setNumeroCaballos(int numeroCaballos) {
		this.numeroCaballos = numeroCaballos;
	}

	public int getNumeroCarreras() {
		return numeroCarreras;
	}

	public void setNumeroCarreras(int numeroCarreras) {
		this.numeroCarreras = numeroCarreras;
	}

	public String getNombreHipodromo() {
		return nombreHipodromo;
	}

	public void setNombreHipodromo(String nombreHipodromo) {
		this.nombreHipodromo = nombreHipodromo;
	}

	public int getCostoCompetencia() {
		return costoCompetencia;
	}

	public void setCostoCompetencia(int costoCompetencia) {
		this.costoCompetencia = costoCompetencia;
	}

	public int getPremioEconomico() {
		return premioEconomico;
	}

	public void setPremioEconomico(int premioEconomico) {
		this.premioEconomico = premioEconomico;
	}


	// Método para calcular el número total de premios repartidos
    public int calcularTotalPremios(int numeroCarreras2, int premioEconomico2) {
        int TotalPremios=numeroCarreras*premioEconomico;
        return TotalPremios;
        
    }
    
 // Método para calcular la cantidad total cobrada por los caballos
    public int calcularTotalCobradoPorCaballos(int numeroCaballos, int numeroCarreras,int costoCompetencia) {
        
        int cantidadCobrada= numeroCaballos * numeroCarreras * costoCompetencia;
         return cantidadCobrada;
    }
    
    
    
  
    
}

	
