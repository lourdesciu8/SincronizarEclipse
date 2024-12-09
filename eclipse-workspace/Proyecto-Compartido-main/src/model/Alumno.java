package model;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<String> modulos;
    private ArrayList<Double> notas; 

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.modulos = new ArrayList<>(); //Así cada alumno tiene su lista de módulos
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarNota(String modulo, double nota) {
        this.modulos.add(modulo);
        this.notas.add(nota);
    }

    public ArrayList<String> getModulos() {
        return modulos;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public String mostrarNotas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < modulos.size(); i++) {
            sb.append("Módulo: ").append(modulos.get(i))
              .append(", Nota: ").append(notas.get(i))
              .append("\n");
        }
        return sb.toString();
    }
}
