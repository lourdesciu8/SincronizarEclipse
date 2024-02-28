package Tarea2Trimestre;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEjercicio3{

    private int numeroCarreras;
    private int premioEconomico; 
    private int TotalPremios;
    
	
public TestEjercicio3(int numeroCarreras, int premioEconomico, int TotalPremios) {
		
		this.numeroCarreras = numeroCarreras;
		this.premioEconomico = premioEconomico;
		this.TotalPremios=TotalPremios;
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
	int costoTotal=objeto.calcularTotalPremios();
	assertEquals(TotalPremios, costoTotal);
	
}

}
