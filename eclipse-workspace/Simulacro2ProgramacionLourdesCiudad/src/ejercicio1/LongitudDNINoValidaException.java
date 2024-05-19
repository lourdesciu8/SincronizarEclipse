package ejercicio1;

public class LongitudDNINoValidaException {
	
	public static void validarDNI(String dni) throws IllegalArgumentException {
	    if (dni.length() != 9) {
	        throw new IllegalArgumentException("La longitud del dni debe ser de 9 caracteres");
	    }
	}
	
}

/*Otra opción hubiera sido:
 * public class LongitudDNINoValidaException extends Exception{
		public LongitudDNINoValidaException (String mensaje){
		super(mensaje);
		El constructor padre se encarga de lanzar la excepción y mostrar el mensaje.
	}
}
*/
