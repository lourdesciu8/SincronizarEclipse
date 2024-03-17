package AlumnoDNI;

class Alumno {
    private String nombre;
    private String apellido;
    private String dni;

    // Constructor por defecto
    public Alumno() {
    }

    // Constructor con parámetros
    public Alumno(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método para comprobar DNI
    public boolean comprobarDNI() {
        if (dni.length() != 9) {
            return false;
        }

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(dni.substring(0, 8));
        int resto = numero % 23;
        char letra = dni.charAt(8);

        return letra == letras.charAt(resto);
    }
}
