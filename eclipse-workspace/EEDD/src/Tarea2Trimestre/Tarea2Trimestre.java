package Tarea2Trimestre;

import java.nio.channels.NonReadableChannelException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Tarea2Trimestre {
	//Variables
	private String nombre, dni;
	private int dorsal, puntuacionEjercicio, dificultad;
	private LocalDate fechaNacimiento;
	
	//Constructores
	public Tarea2Trimestre(int puntuacionEjercicio, int dificultad) {
		this.puntuacionEjercicio = puntuacionEjercicio;
		this.dificultad = dificultad;
	}
	
	
	public Tarea2Trimestre(String nombre, String dni, LocalDate fechaNacimiento, int dorsal) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.dorsal = dorsal;
		
	}
	
	//Método 1 para calcular la puntuación final 
	

	public int CalcularPuntuacionFinal(int puntuacionEjercicio, int dificultad) {
		
		if (puntuacionEjercicio>0 && dificultad>0) {
		
		int PuntuacionFinal=puntuacionEjercicio*dificultad;
		
		return PuntuacionFinal;
		
		} else {
			
			return -1;
		}
	}
	
	
	//Método 2 para calcular si el participante es o no mayor de edad 
	public boolean ComprobarMayorDeEdad(){  
	     boolean MayorEdad; 
	     LocalDate hoy =LocalDate.now();    
	     Period periodo=Period.between(fechaNacimiento, hoy);  
	     
	     int edad=periodo.getYears(); 
	   if (edad>=18){ 
		   MayorEdad=true;
	    }  
	    else {
	    	MayorEdad=false;
	    }
	return MayorEdad;
	} 

	 
}

	
