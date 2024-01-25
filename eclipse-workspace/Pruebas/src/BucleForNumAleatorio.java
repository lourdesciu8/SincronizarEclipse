import java.util.Scanner;

public class BucleForNumAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Se generan números aleatorios
				int aleatorio;
				int acumulador=0;
				Scanner sc=new Scanner (System.in);
				
				for(int i=0;i<4;i++) {
					
					aleatorio=(int)(Math.random()*100);
					System.out.println(aleatorio);
					acumulador=acumulador + aleatorio;
				}
				System.out.println("El valor de todos los números introducidos es: " +acumulador);
		
	}

}


