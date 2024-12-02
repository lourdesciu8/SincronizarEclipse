package models;

import java.io.Serializable;

public class Pedido implements Serializable {
    private int id;
    private int idProducto;
    private String descripcion;
    private double precioTotal;

    //Constructores
    public Pedido(int id, int idProducto, String descripcion, double precioTotal) {
        this.id = id;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precioTotal = precioTotal;
    }

    public Pedido(int idProducto, String descripcion, double precioTotal) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precioTotal = precioTotal;
    }

    public Pedido() {
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Pedido: id=" + id + ", idProducto=" + idProducto +
                ", descripcion=" + descripcion +
                ", precioTotal=" + precioTotal;
    }
}
