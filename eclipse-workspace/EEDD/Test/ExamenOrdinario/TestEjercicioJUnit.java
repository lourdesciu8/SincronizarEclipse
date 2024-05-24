package ExamenOrdinario;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TestEjercicioJUnit{
	//Poner atributos para variable donde se guarda el método que crees
    
    
//Poner constructor de las variables de arriba

@Parameters
public static Collection<Object[]> datos() {
	return Arrays.asList(new Object[][] { 
		{, , , },{ , , , },{ , , , }
		}
		);

}

@org.junit.Test //Test
public void Test() {
	
	EjercicioJUnit objeto1=new EjercicioJUnit( , , );
	double X=objeto1.NombreMetodo( , , ); 
	assertEquals(CantidadTotal,X);
	
	//assertEquals(Valor esperado, Valor real);
	}

}

