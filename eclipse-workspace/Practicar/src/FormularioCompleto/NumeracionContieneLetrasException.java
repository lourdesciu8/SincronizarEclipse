package FormularioCompleto;

public class NumeracionContieneLetrasException {
public static void NumeracionContieneLetras (String dni) throws IllegalArgumentException {
	for (int i = 0; i < 8; i++){
        if (!Character.isDigit(dni.charAt(i))){
            throw new IllegalArgumentException("Los 8 primeros números del DNI contienen caracteres no válidos");
        	}
    	}
	}
}
