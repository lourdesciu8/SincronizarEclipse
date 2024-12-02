package models;

import java.io.Serializable;

public class Empleado implements Serializable {
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;

    //Constuctores
    public Empleado(int id, String nombre, String apellidos, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public Empleado(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public Empleado() {
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Empleado: id=" + id + ", nombre=" + nombre +
                ", apellidos=" + apellidos +
                ", correo=" + correo;
    }
}
