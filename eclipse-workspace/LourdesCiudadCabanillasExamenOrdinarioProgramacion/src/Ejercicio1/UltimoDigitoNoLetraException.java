package Ejercicio1;

public class UltimoDigitoNoLetraException {
	public static void ComprobarLetradni (String dni) throws IllegalArgumentException{
		if (Character.isDigit(dni.charAt(8))) {
			throw new IllegalArgumentException("El último caracter siempre debe ser una letra");
		}	
	}
}
