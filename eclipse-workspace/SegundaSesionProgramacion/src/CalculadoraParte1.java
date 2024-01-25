import java.util.Scanner;

public class CalculadoraParte1 {

	public static void main(String[] args) {
		
		//Debes de crear una calculadora. La aplicación mostrará un menú con las operaciones que puede realizar
		/*(sumar, restar, multiplicar, dividir y resto).También debe pedir al usuario que introduzca los dos números.
		 *Para la operación de restar debemos de comprobar que reste el número mayor menos el menor, es decir que si 
		 *el usuario introduce, por ejemplo, 5 y 7 deberá hacer 7-5, no puede dar un número negativo.
		 *Para la operación división el divisor no podrá ser cero, en dicho caso le mostrará un mensaje
		 *diciendo que no se puede hacer la división. La aplicación terminará cuando lo diga el usuario.
		 */
		
		//Variables
        int num1, num2, operacion;
        Scanner sc=new Scanner (System.in);
        
        //Petición de datos
        System.out.print("Introduce un número: ");
        num1=sc.nextInt();
        System.out.print("Introduce otro número: ");
        num2=sc.nextInt();
        
        System.out.println("Elija una operación matemática (1-5): ");
        System.out.println("\n1: Sumar \n2: Restar \n3: Multiplicar \n4: Dividir \n5: Resto");
        
		operacion=sc.nextInt();
        
        switch (operacion) {
        case 1:
            System.out.println("La suma de ambos números es igual a " + (num1+num2));
            break;
        
        case 2:
        	if (num1>=num2) {
            System.out.println("La resta de ambos números es igual a " + (num1-num2));
            }
            else {
            	 System.out.println("La resta de ambos números es igual a " + (num2-num1));
            }
            break;
        
        case 3:
            System.out.println("La multiplicación de ambos números es igual a " + (num1*num2));
            break;
		
        case 4:
            if (num2==0) {
            	System.out.println("No se puede hacer la división");
            }	
            else {
            	System.out.println("La división de ambos números es igual a " + (num1/num2));
            }
            break;
            
        case 5:
            if (num2==0) {
            	System.out.println("No se puede calcular el resto");
            }	
            else {
            	System.out.println("El resto de la operación es igual a " + (num1%num2));
            }
            break;
            
        default:
        	System.out.println("Opción incorrecta");
        }
	}

}

		
		
		
		

