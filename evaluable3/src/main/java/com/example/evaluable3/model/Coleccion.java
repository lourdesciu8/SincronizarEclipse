package com.example.evaluable3.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "colecciones")
public class Coleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColeccion;

    private String nombre;
    private String temporada;
    private int anio;

    //Una coleccion de ropa esta formada por muchas prendas
    @OneToMany(mappedBy = "coleccion", cascade = CascadeType.ALL)
    private List<Prenda> prendas;

    // Getters y Setters

    public Long getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Long idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }

    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    public Coleccion(String nombre, String temporada, int anio) {
        this.nombre = nombre;
        this.temporada = temporada;
        this.anio = anio;
    }

    public Coleccion() {
    }
}
