package Tarea2Trimestre;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEjercicio2{
	private int numeroAlumnos;
    private int numeroAsignaturas;
    private double costoPorAsignatura=75.0;
    private double totalCobrado;
    

public TestEjercicio2(int numeroAlumnos, int numeroAsignaturas, double costoPorAsignatura, double totalCobrado ) {
	
	this.numeroAlumnos = numeroAlumnos;
	this.numeroAsignaturas = numeroAsignaturas;
	this.costoPorAsignatura = costoPorAsignatura;
	this.totalCobrado=totalCobrado;
	
}

@Parameters
public static Collection<Object[]> datos() {
	return Arrays.asList(new Object[][] { 
		{10,5,75,3750},{4,9,75,2700},{6,10,75,4500}
		}
		);

}

@org.junit.Test //Test
public void Test() {
	
	Ejercicio2 objeto1=new Ejercicio2(numeroAlumnos, numeroAsignaturas, costoPorAsignatura);
	double costoTotal=objeto1.calcularTotalCobrado(numeroAlumnos, numeroAsignaturas, costoPorAsignatura);
	assertEquals(totalCobrado,costoTotal);
	
}

}

