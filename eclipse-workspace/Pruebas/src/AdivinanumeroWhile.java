import java.util.*;
public class AdivinanumeroWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Se quiere generar un nº aleatorio entre 0 y 100.
		
		//Math.random devuelve un dato entre 0 y 1 decimal (double) y hay que convertirle a entero (int), 
		/* para ello hay que hacer una refundición para hacer el cambio de variable y multiplicar x100.
		 */
		int aleatorio=(int)(Math.random()*100);
		Scanner sc=new Scanner(System.in);
		int numero=0;
		int intentos=0;
		
		//Mientras la variable numero y alatorio sean diferentes, se ejecutará el bucle.
		while(numero!=aleatorio) {
			//Cuando comienza el bucle, la variable intentos va aumentando de 1 en 1 a medida que se realizan intentos.
			intentos++;
			System.out.println("Introduce un nº");
			numero=sc.nextInt();
			if (aleatorio<numero) {
				System.out.println("Nº generado por el programa es menor que el introducido por mi");
			}
			
			else if(aleatorio>numero){
				System.out.println("Nº generado por el programa es mayor que el introducido por mi");
			}
		}
		//Si nos salimos del bucle es porque la variable numero y aleatorio son iguales.
		System.out.println("Correcto. Lo has conseguido en " + intentos +  " intentos");
	}
	

}
