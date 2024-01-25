import java.util.Scanner;

public class CalculadoraParte2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Debes de crear una calculadora. La aplicación mostrará un menú con las operaciones que puede 
				/*realizar (sumar, restar, multiplicar, dividir y resto).También debe pedir al usuario que
				 *introduzca los dos números. Para la operación de restar debemos de comprobar que reste el número
				 *mayor menos el menor. Para la operación división el divisor no podrá ser cero.
				 *Se debe incluir un bucle para que empiece de nuevo. La aplicación terminará cuando lo diga el usuario.
				 */
				
				//Variables
		        int num1, num2, operacion, resultado;
		        Scanner sc=new Scanner (System.in);
		        
		        //Petición de datos
		        do {
		        	
		        System.out.print("Introduce un número: ");
		        num1=sc.nextInt();
		        System.out.print("Introduce otro número: ");
		        num2=sc.nextInt();
		        System.out.println("Elija una operación matemática (1-5): ");
		        System.out.println("\n1: Sumar \n2: Restar \n3: Multiplicar \n4: Dividir \n5: Resto");
		        operacion=sc.nextInt();
	                
				} while (operacion<=0 || operacion>=6);
		        
		        switch (operacion) {
		        case 1:
		        	resultado=num1+num2;
		            System.out.println("La suma de ambos números es igual a " + resultado);
		            break;
		        
		        case 2:
		        	resultado=num1-num2;
		        	if (num1>=num2) {
		            System.out.println("La resta de ambos números es igual a " + resultado);
		            }
		            else {
		            	 System.out.println("La resta de ambos números es igual a " + (num2-num1));
		            }
		            break;
		        
		        case 3:
		        	resultado=num1*num2;
		            System.out.println("La multiplicación de ambos números es igual a " + resultado);
		            break;
				
		        case 4:
		        	
		            if (num2==0) {
		            	System.out.println("No se puede hacer la división");
		            }	
		            else {
		            	resultado=(num1/num2);
		            	System.out.println("La división de ambos números es igual a " + (resultado));
		            }
		            break;
		            
		        case 5:
		        	
		            if (num2==0) {
		            	System.out.println("No se puede calcular el resto");
		            }	
		            else {
		            	resultado=(num1%num2);
		            	System.out.println("El resto de la operación es igual a " + resultado);
		            }
		            break;
		        
		        default:
		        	System.out.println("¡Hasta luego!");
		        }
		    }
		}


				