package models;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String title;
    private String description;
    private int stock;
    private double price;

    //Constructores
    public Producto(int id, String title, String description, int stock, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public Producto() {
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Producto: id=" + id + ", title=" + title +
                ", description=" + description +
                ", stock=" + stock +
                ", price=" + price;
    }
}

