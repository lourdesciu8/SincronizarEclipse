package FormularioCompleto;

public class LongitudTelefonoNoValidaException {
    public static void comprobarLongitud(String telefono) throws IllegalArgumentException {
        if (telefono.length() != 9) {
            throw new IllegalArgumentException("La longitud del número de teléfono debe ser igual a 9 dígitos");
        }
    }
}
