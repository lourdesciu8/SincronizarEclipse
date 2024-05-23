package FormularioCompleto;

public class TipoDatoIncorrectoException {
	public static void NombreIncorrecto(String nombre) throws IllegalArgumentException {
		for (int i = 0; i < nombre.length(); i++){
            if (Character.isDigit(nombre.charAt(i))){
            throw new IllegalArgumentException("No puede haber dígitos en el nombre.");
            }
		}
	}
	
	public static void ApellidosIncorrecto(String apellidos) throws IllegalArgumentException {
		for (int i = 0; i < apellidos.length(); i++){
            if (Character.isDigit(apellidos.charAt(i))){
            throw new IllegalArgumentException("No puede haber dígitos en los apellidos.");
            }
		}
	}
}
