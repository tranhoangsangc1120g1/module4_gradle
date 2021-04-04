package com.thuchanh.service.impl;

import com.thuchanh.model.Product;
import com.thuchanh.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductRepo {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product model) {
        productRepo.save(model);
    }

    @Override
    public void remove(Long id) {
        productRepo.remove(id);
    }
}
