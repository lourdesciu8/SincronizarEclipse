import javax.swing.JOptionPane;

public class Arrays_BucleForEachAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Generamos 150 números aleatorios utilizando un array y un bucle for each (bucle mejorado)
		int[] matriz_aleatorios=new int[150];
				
			for(int i=0; i<matriz_aleatorios.length;i++) {
					matriz_aleatorios[i]=(int)Math.round(Math.random()*100);
				}
			
			for(int numeros:matriz_aleatorios) {
			//En este caso se utiliza print en lugar de println para que salgan todos a continuación y no hacia abajo
				System.out.print(numeros + " ");
			}

		}
	
}

