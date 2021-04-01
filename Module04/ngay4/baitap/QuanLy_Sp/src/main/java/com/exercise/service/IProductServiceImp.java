package com.exercise.service;

import com.exercise.model.Product;
import com.exercise.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IProductServiceImp implements IProductService {
    @Autowired
    IProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
       productRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
       productRepo.update(id,product);
    }

    @Override
    public void remove(int id) {
       productRepo.remove(id);
    }
}
