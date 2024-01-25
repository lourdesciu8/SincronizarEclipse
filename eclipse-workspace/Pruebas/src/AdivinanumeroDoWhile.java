import java.util.Scanner;

public class AdivinanumeroDoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Do while asegura que aunque la condición de entrada sea falsa, se ejecute lo del bucle al 
		/*menos una vez mientras que con while si a la primera vez la condición es falsa,
		 * no se ejecute el código de dentro del while. Se aprovecha el ejemplo de AdivinanumeroWhile
		 * para transformarle a do while.
		 */
		
		int aleatorio=(int)(Math.random()*100);
		Scanner sc=new Scanner(System.in);
		int numero=0;
		int intentos=0;
		
		//Mientras la variable numero y alatorio sean diferentes, se ejecutará el bucle.
		do{
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
		}while(numero!=aleatorio);
		
		//Si nos salimos del bucle es porque la variable numero y aleatorio son iguales.
		System.out.println("Correcto. Lo has conseguido en " + intentos +  " intentos");
	}

}
