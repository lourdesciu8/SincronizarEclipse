package Tarea2Trimestre;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Test2Ejercicio3{
	private int numeroCaballos;
    private int numeroCarreras;
    private String nombreHipodromo;
    private int costoCompetencia = 50; 
    private int premioEconomico; 
    private int TotalPremios;
    private int cantidadCobrada;


public Test2Ejercicio3(int numeroCaballos, int numeroCarreras, int costoCompetencia) {
		this.numeroCaballos = numeroCaballos;
		this.numeroCarreras = numeroCarreras;
		this.costoCompetencia = costoCompetencia;
	}

@Parameters
public static Collection<Object[]> datos() {
	return Arrays.asList(new Object[][] { 
		{8,3,50,1200},{10,2,50,1000},{15,5,50,3750},{5,4,50,1000},
		}
		);

}

@org.junit.Test //Test
public void Test() {
	
	Ejercicio3 objeto2=new Ejercicio3(numeroCaballos,numeroCarreras,costoCompetencia);
	int TotalCobradoCaballos=objeto2.calcularTotalCobradoPorCaballos(numeroCaballos,numeroCarreras,costoCompetencia);
	assertEquals(cantidadCobrada, TotalCobradoCaballos);
	
}

}
