package Tarea2Trimestre;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class Test1{
	private int PuntuacionFinal;
	private int puntuacionEjercicio;
	private int dificultad;

public Test1(int puntuacionEjercicio,int dificultad,int PuntuacionFinal ) {
	
	this.puntuacionEjercicio=puntuacionEjercicio;
	this.dificultad=dificultad;
	this.PuntuacionFinal=PuntuacionFinal;
}

@Parameters
public static Collection<Object[]> datos() {
	return Arrays.asList(new Object[][] { 
		{10,2,20},{4,9,36},{6,5,30}
		}
		);

}

@org.junit.Test //Test
public void TestPuntuacion() {
	
	Tarea2Trimestre objeto1=new Tarea2Trimestre(puntuacionEjercicio, dificultad);
	int puntuacion=objeto1.CalcularPuntuacionFinal(puntuacionEjercicio, dificultad);
	assertEquals(PuntuacionFinal,puntuacion);
	
}

}





