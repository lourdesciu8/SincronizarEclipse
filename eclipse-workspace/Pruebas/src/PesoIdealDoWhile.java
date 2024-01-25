import javax.swing.*;
public class PesoIdealDoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String genero="";
		
		do{
			genero=JOptionPane.showInputDialog("Introduce tu género (H/M)");
		
			//El bucle se repite si lo que el usuario introduce en la ventana es diferente a H y a M.
			/*Al utilizar equalsIgnoreCase en lugar de equals a secas, te da la posibilidad de introducir
			 *mayúsculas o minúsculas indistintamente.
			 */
		}while(genero.equalsIgnoreCase("H")==false && genero.equalsIgnoreCase("M")==false);
		
		//showInputDialog devuelve un String, por lo que hay que pasarlo a entero (int):
		int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en cm"));
		int pesoideal=0;
		
		if(genero.equalsIgnoreCase("H")){
			pesoideal=altura-110;
		}
		else if(genero.equalsIgnoreCase("M")){
			pesoideal=altura-120;
		}
		
		System.out.println("Tu peso ideal es " + pesoideal + " kg");
	}

}
