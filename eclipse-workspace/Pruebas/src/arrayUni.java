import java.util.Scanner;

public class arrayUni {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//Creación y asignación de espacio en el array
		int nombreArray [] = new int [6];
		
		nombreArray[0]=8;
		System.out.print(nombreArray[0]);
		
		//Guardar información en el array
		for(int i=0;i<nombreArray.length;i++) {
			System.out.print("Dime un numero: ");
			nombreArray[i]=sc.nextInt();
		}
		
		//Recorrer el array y mostrar el contenido de cada posición
		for(int i=0;i<nombreArray.length;i++) {
			/*if(nombreArray[i]==5) {
				System.out.println("Encontrado en la posicion "+i);
			*/
			System.out.println("Contenido en la posicion "+i+" "+nombreArray[i]);
		}
		
		//System.out.print("El contenido en la posicion 4 es: "+nombreArray[4]);
		
		
	}

}
