package ExcepcionTelefono;


public class valorIncorrecto {
	
	public static void validarTelefono(String telefono) throws IllegalArgumentException {
	    if (telefono.length() != 9) {
	        throw new IllegalArgumentException("El teléfono debe tener 9 dígitos");
	    }
	}
}
