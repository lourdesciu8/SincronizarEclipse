package Tarea2Trimestre;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.validator.PublicClassValidator;


@RunWith(Parameterized.class)
public class Test2{
	 private String nombre, dni;
	 private LocalDate fechaNacimiento;
	 private int dorsal;
	 private boolean MayorDeEdad;
	


public Test2(String nombre, String dni, LocalDate fechaNacimiento, int dorsal, boolean MayorDeEdad) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.dorsal = dorsal;
		this.MayorDeEdad = MayorDeEdad;
	}

@Parameters
public static Collection<Object[]> datos() {
	return Arrays.asList(new Object[][] { 
		{ "Noelia", "53468910L", LocalDate.of(1994, 4, 28), 2, true},
        { "Sara", "34907612K", LocalDate.of(2000, 9, 10),35, true},
        { "Raul", "99675355A", LocalDate.of(2021, 8, 31), 16, false}
		}
		);

}

@org.junit.Test //Test
public void TestEdad() {
	
	Tarea2Trimestre objeto2=new Tarea2Trimestre(nombre, dni, fechaNacimiento, dorsal);
	boolean Edad=objeto2.ComprobarMayorDeEdad();
	assertEquals(MayorDeEdad,Edad);
	
}

}
