package FormularioCompleto;

public class UltimoDigitoNoLetraException {
	public static void ComprobarLetra (String dni) throws IllegalArgumentException{
		char ultimochar=dni.charAt(8);
		if (Character.isDigit(ultimochar)) {
			throw new IllegalArgumentException("El último caracter debe ser una letra");
		}	
	}
}
