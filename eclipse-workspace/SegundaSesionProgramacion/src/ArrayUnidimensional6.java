	import java.util.Scanner;
public class ArrayUnidimensional6 {

	public static void main(String[] args) {
		// Pide al usuario por teclado una frase y pasa sus caracteres a un array de caracteres
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escriba una frase");
		
		// Usamos nextLine en lugar de next por los espacios
		// next cogería hasta el primer espacio mientras que nextLine coge hasta el primer enter
		String frase = teclado.nextLine();
		
		//Creamos un array de caracteres
		char caracteres[] = new char[frase.length()];
		
		//Recorremos la frase, cogemos cada caracter y lo metemos en el array
		for(int i=0;i<frase.length();i++){
		caracteres[i]=frase.charAt(i);
		System.out.println(caracteres[i]);

		}

	}	
}
