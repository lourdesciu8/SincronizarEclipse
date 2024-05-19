package ejercicio1;

public class UltimoDigitoNoLetraException{
	public static void validarDNI2(String dni) throws IllegalArgumentException {
	    char ultimoChar = dni.charAt(8);
	    //dni.charAt(0)-1  sería exactamente lo mismo aquí que dni.charAt(8)
	    if (!Character.isLetter(ultimoChar)) {
	        throw new IllegalArgumentException("El último dígito del DNI siempre debe de ser una letra.");
	    }
	}
}

/*Otra opción hubiera sido:
 * public class UltimoDigitoNoLetraException extends Exception{
		public UltimoDigitoNoLetraException (String mensaje){
		super(mensaje);
	}
}
*/