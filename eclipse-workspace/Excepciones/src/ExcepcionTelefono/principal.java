package ExcepcionTelefono;

import java.io.IOException;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String telefono;
		
		System.out.println("Dime el telefono:");
		telefono=sc.nextLine();
		try {
			 valorIncorrecto.validarTelefono(telefono);;  // Valida la longitud del telefonp
		   System.out.println("Valor válido");
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " +e.getMessage());
	    }
		
	}

}
