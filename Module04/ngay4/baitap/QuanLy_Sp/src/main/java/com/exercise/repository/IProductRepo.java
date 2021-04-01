package com.exercise.repository;

import com.exercise.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

}
