
public class Uso_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] mi_matriz=new int [5];
		mi_matriz[0]=5;
		mi_matriz[1]=38;
		mi_matriz[2]=-15;
		mi_matriz[3]=92;
		mi_matriz[4]=71;
		
		//Se podría imprimir así cada valor almacenado en el array
		System.out.println(mi_matriz[0]);
		System.out.println(mi_matriz[1]);
		System.out.println(mi_matriz[2]);
		System.out.println(mi_matriz[3]);
		System.out.println(mi_matriz[4]);
		
		//El bucle for es ideal para recorrer todos los valores almacenados en la matriz, e imprimirlos en consola;
		/*y se usa sobre todo para matrices con muchos elementos.
		 */
		
		for(int i=0;i<5;i++) {
			System.out.println("Valor del índice " + i + " = " + mi_matriz[i]);
		}
		
		//Otra forma de declarar la matriz de forma simplificada o implícita sería:
		/*int nombrematriz []= {5, 38, -15, 92, 71};
		 */
		
		//Cuando hay muchos elementos y no sabemos cuantos son exactamente, para declarar el bucle se usa length:
		for(int i=0;i<mi_matriz.length;i++) {
			System.out.println("Valor del índice " + i + " = " + mi_matriz[i]);
			
		}
	}

}
