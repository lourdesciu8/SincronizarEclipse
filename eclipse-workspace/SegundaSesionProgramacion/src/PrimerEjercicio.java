import java.util.Scanner;

public class PrimerEjercicio {

	public static void main(String[] args) {
		//Comentarios en Java
		/*comentarios
		 * en distintos
		 * párrafos
		 */
		
		//Variables
		int numero=5;  //Para números enteros usar int
		double numero2=6.8;//Para números con decimales usar double y siempre separado por punto.
		char letra='d';//Para una letra solamente
		String palabra="Lourdes"; //String es para más de una letra
		boolean verdadero=false;  //Puede tomar solo valores verdaderos o falsos
		
		
		//Constantes hay que usar siempre delante la palabra final
		final int VALOR=8; //Poner constantes en mayusculas
		
		System.out.println(palabra);
		//Todo lo que esté entre comillas se imprime tal cual,
		/*en cambio si lo que quiero imprimir es el contenido de una variable, 
		 * debe ir sin comillas
		 */
		System.out.println("Hola " + palabra + " Bienvenida a Java");	
		// se usa el simbolo + para concatenar 
		
		int num1=12, num2=9, suma; //Se pueden declarar tantas variables como se quieran separadas por comas
		suma=num1+num2;
		System.out.println("El resultado de la suma es: " +suma);
		
		//Hacer ejemplo de resta, multiplicación y división
		int resta = num1-num2;
		System.out.println("El resultado de la resta es: " +resta);
		
		int multiplicacion = num1*num2;
		System.out.println("El resultado de la multiplicación es: " +multiplicacion);
		
		int division = num1/num2;
		System.out.println("El resultado de la división es: " +division);
		
		//Hacer ejemplo del resto

		int resto=num1%num2;

		System.out.println("El resultado del resto es: " +resto);
		
		
		Scanner sc= new Scanner (System.in); // Scanner se utiliza para leer datos 
		/*que el usuario introduce por teclado
		 * el scanner se puede nombrar como quieras, aquí se usó sc
		 */
		System.out.println("Dime un número: ");
		int oper1=sc.nextInt();
		System.out.println(oper1);
	
				//Orden de estructuras para ejercicios
		/* Variables y constantes
		 * Peticiones de datos
		 * Operaciones
		 * Mostrar resultados
		 */		 
		

	}

}
