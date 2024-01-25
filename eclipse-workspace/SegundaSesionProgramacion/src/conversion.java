import java.util.Scanner;

public class conversion {

	public static void main(String[] args) {
		int valor;
		double valor2;
		long num;
		float num2;
		String numero="3";
		String numero2="2.5";
		
		//Para pasar de String a int:
		valor=Integer.parseInt(numero);
		
		//Para pasar de String a Double:
		valor2=Double.parseDouble(numero2);
		
		//Para pasar de String a Long:
		num=Long.parseLong(numero);
		
		//Para pasar de String a Float:
		num2=Float.parseFloat(numero2);
		
		//Pasar de int a String
		numero=String.valueOf(valor);
		
		//Pasar de double a String
		numero2=String.valueOf(valor2);

		
		System.out.println(valor);
		System.out.println(valor2);
		System.out.println(num);
		System.out.println(num2);
		System.out.println(numero);
		System.out.println(numero2);
	}

}
