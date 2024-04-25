package Simulacro;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TestEjercicio{
	protected int numeroPistas;
    protected int numeroEsquiadores;
    protected double costoForfait=50.0;
    protected double CantidadTotal;
    
    
public TestEjercicio(int numeroPistas, int numeroEsquiadores, double costoForfait, double CantidadTotal) {
		this.numeroPistas = numeroPistas;
		this.numeroEsquiadores = numeroEsquiadores;
		this.costoForfait = costoForfait;
		this.CantidadTotal = CantidadTotal;
	}

@Parameters
public static Collection<Object[]> datos() {
	return Arrays.asList(new Object[][] { 
		{10,5,50,2500},{4,9,50,1800},{6,10,50,3000}
		}
		);

}

@org.junit.Test //Test
public void Test() {
	
	Ejercicio objeto1=new Ejercicio(numeroPistas, numeroEsquiadores, costoForfait);
	double costoTotal=objeto1.CalcularCantidadTotal(numeroPistas, numeroEsquiadores, costoForfait); 
	assertEquals(CantidadTotal,costoTotal);
	
	}

}

