package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepo;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepo iProductRepo;
    @Override
    public Page<Product> findAllProduct(Pageable page) {
        return iProductRepo.findAll(page);
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id).orElse(null);
    }
}
