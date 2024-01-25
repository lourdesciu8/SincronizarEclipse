import javax.swing.JOptionPane;

public class Arrays_BucleForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] paises=new String [8];
		
		paises[0]="España";
		paises[1]="México";
		paises[2]="Colombia";
		paises[3]="Perú";
		paises[4]="Chile";
		paises[5]="Argentina";
		paises[6]="Ecuador";
		paises[7]="Venezuela";
		
		//Ejemplo con bucle for
		for(int i=0;i<paises.length;i++) {
			System.out.println("País " + (i+1) + " " + paises[i]);
		}
		
		//Ahora se va a usar el bucle for each, olvidándote de que posición partes y a cual posición llegas.
		/*la variable dentro del for en este caso es de tipo String porque el array es de este tipo, 
		 * es muy útil para recorrer una matriz 
		 */
		
		for(String elemento:paises) {
			System.out.println("País: " +elemento);
		}
		
		//Sería lo mismo hacerlo así:
		/*String [] paises=new String [8];
		
		for(int i=0;i<8;i++) {
			paises[i]=JOptionPane.showInputDialog("Introduce país " + (i+1));
			
		}
		
		for(String elemento:paises) {
			System.out.println("País: " + elemento);
			*/
	}

}
