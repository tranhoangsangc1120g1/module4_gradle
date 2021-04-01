package com.exercise.model;

public class Product {
    private int id;
    private String name;
    private String manufactory;

    public Product(int id, String name, String manufactory) {
        this.id = id;
        this.name = name;
        this.manufactory = manufactory;
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

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }
}
