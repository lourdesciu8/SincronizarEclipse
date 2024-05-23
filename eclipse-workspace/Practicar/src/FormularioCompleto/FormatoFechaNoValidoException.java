package FormularioCompleto;

public class FormatoFechaNoValidoException {
    public static void comprobarFecha(String fecha) throws IllegalArgumentException {
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("La fecha de nacimiento debe tener el formato dd/mm/yyyy");
        }
    }
}
