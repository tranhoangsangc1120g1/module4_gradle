package com.exercise.model;

public class Product {
    private int id;
    private String name;
    private String manufacture;

    public Product(int id, String name, String manufacture) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufactur) {
        this.manufacture = manufacture;
    }
}
