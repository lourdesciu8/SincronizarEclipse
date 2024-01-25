import java.util.Scanner;

public class EjercicioMedia {

	public static void main(String[] args) {
		

		Scanner sc= new Scanner (System.in); 
		System.out.println("Dime el nombre: ");
		String name1=sc.next();
		System.out.println(name1);
		
		//Ejemplo con números enteros
		
		System.out.println("Dime un número");
		int num1=sc.nextInt();
		System.out.println(num1);
		
		System.out.println("Dime otro número");
		int num2=sc.nextInt();
		System.out.println(num2);
		
		System.out.println("Dime otro número");
		int num3=sc.nextInt();
		System.out.println(num3);
		
		System.out.println("Bienvenida " +name1 +": tu nota media es " +((num1+num2+num3)/3));
		
		
		//Ejemplo con números decimales
		
		System.out.println("Dime el nombre: ");
		String name2=sc.next();
		System.out.println(name2);
		
		System.out.println("Dime un número");
		double num4=sc.nextDouble();
		System.out.println(num4);
		
		System.out.println("Dime otro número");
		double num5=sc.nextDouble();
		System.out.println(num5);
		
		System.out.println("Dime otro número");
		double num6=sc.nextDouble();
		System.out.println(num6);
		
		System.out.println("Bienvenida " +name2 +": tu nota media es " +((num4+num5+num6)/3));
		
	}

}
