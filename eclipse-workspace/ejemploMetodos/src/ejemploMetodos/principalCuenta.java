package ejemploMetodos;

import java.util.Scanner;

public class principalCuenta {
//Esta es la clase principal que es la que tiene el método main
	
	public static void main(String[] args) {
		String titular;
		double cantidad;
		Scanner sc=new Scanner(System.in);
		
		Cuenta c1 = new Cuenta("lourdes");
		Cuenta c2 = new Cuenta("lourdes",1234.9);
		
		System.out.println("El titular de la cuenta 1 es: " +c1.getTitular());
		System.out.println("El titular de la cuenta 2 es: " +c2.getTitular());
		
		//No va a devolver valor , saldrá null, porque el constructor del objeto c1 no tiene cantidad asociada
		System.out.println("La cantidad de la cuenta 1 es: " +c1.getCantidad());
		
		//Con lo cual, le inserto un valor con set
		c1.setCantidad(5678.2);
		System.out.println("La cantidad de la cuenta 1 es: " +c1.getCantidad());
		
		System.out.println("La cantidad de la cuenta 2 es: " +c2.getCantidad());
		
		//Quiero ingresar dinero en la cuenta 1 que tengo inicialmente 1234,9 euros
		System.out.println("La cantidad de la cuenta 1 es: " +c1.getCantidad());
		//Ingreso 1000 euros
		c1.ingresarDinero(1000);
		System.out.println("La cantidad de la cuenta 1 es: " +c1.getCantidad());
	}
}
