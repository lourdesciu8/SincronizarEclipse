package FormularioCompleto;

public class Usuario {
    protected String nombre;
    protected String apellidos;
    protected String email;
    protected String fechaNacimiento;
    protected String dni;
    protected String telefonoMovil;

    protected Usuario() {
    }

    protected Usuario(String nombre, String apellidos, String email, String fechaNacimiento, String dni, String telefonoMovil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.telefonoMovil = telefonoMovil;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getApellidos() {
        return apellidos;
    }

    protected void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
    	this.email=email;
    }

    protected String getFechaNacimiento() {
        return fechaNacimiento;
    }

    protected void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    protected String getDni() {
        return dni;
    }

    protected void setDni(String dni) {
        this.dni = dni;
    }

    protected String getTelefonoMovil() {
        return telefonoMovil;
    }

    protected void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "nombre=" + nombre + ' ' +
                ", apellidos=" + apellidos + ' ' +
                ", email=" + email + ' ' +
                ", fechaNacimiento=" + fechaNacimiento + ' ' +
                ", dni=" + dni + ' ' +
                ", telefonoMovil=" + telefonoMovil + ' ' ;
    }
}
