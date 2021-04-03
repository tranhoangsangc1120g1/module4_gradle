package baitap5.service.impl;

import baitap5.model.Product;
import baitap5.repository.IProductRepo;

import baitap5.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
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
