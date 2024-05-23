package FormularioCompleto;

public class LongitudDNINoValidaException {
    public static void comprobarLongitud(String dni) throws IllegalArgumentException {
        if (dni.length() != 9) {
            throw new IllegalArgumentException("La longitud del DNI debe ser igual a 9 caracteres");
        }
    }
}
