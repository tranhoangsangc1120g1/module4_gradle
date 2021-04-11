package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProduct(Pageable page);
    Product findById(int id);
}
