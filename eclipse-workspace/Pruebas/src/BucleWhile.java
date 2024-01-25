import javax.swing.JOptionPane;

public class BucleWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String clave="Lourdes";
		String pass="";
		
		//Significa que si las cadenas de texto "clave" y "pass" NO son iguales , se ejecuta el bucle while,
		/*en el momento que SÍ sean iguales y por tanto la condición sea true en lugar de false, 
		 *nos salimos del bucle while y se sigue la ejecución con la siguiente instrucción.
		 */
		while (clave.equals(pass)==false){
			pass=JOptionPane.showInputDialog("Introduce la contraseña");
			if (clave.equals(pass)==false) {
				System.out.println("Contraseña incorrecta");
				
			}
		}
		
		System.out.println("Contraseña correcta, acceso permitido");	
				
	}

}
