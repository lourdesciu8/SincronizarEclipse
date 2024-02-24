package Tarea2Trimestre;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEjercicio3{
	private int numeroCaballos;
    private int numeroCarreras;
    private String nombreHipodromo;
    private int costoCompetencia = 50; 
    private int premioEconomico; 
    private int TotalPremios;
    
	
public TestEjercicio3(int numeroCarreras, int premioEconomico) {
		
		this.numeroCarreras = numeroCarreras;
		this.premioEconomico = premioEconomico;
	}



@Parameters
public static Collection<Object[]> datos() {
	return Arrays.asList(new Object[][] { 
		{10,50,500},{4,90,360},{5,20,100},
		}
		);

}

@org.junit.Test //Test
public void Test() {
	
	Ejercicio3 objeto=new Ejercicio3(numeroCarreras, premioEconomico);
	int costoTotal=objeto.calcularTotalPremios(numeroCarreras, premioEconomico);
	assertEquals(TotalPremios, costoTotal);
	
}

}
