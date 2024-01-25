import java.util.Scanner;

public class BucleForPedirNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//for(inicialización;condición;incremento){
		//El usuario pide números por teclado
				int num;
				int acumulador=0;
				Scanner sc = new Scanner (System.in);
				
				for(int i=0;i<4;i++) {

					System.out.println("Introduce nº");
					num=sc.nextInt();
					acumulador=acumulador + num;
				}
				System.out.println("El valor de todos los números introducidos es: " +acumulador);
			}

		}
		