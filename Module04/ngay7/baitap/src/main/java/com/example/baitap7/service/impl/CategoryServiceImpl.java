package com.example.baitap7.service.impl;

import com.example.baitap7.model.Category;
import com.example.baitap7.reposity.ICategoryRepository;
import com.example.baitap7.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl  implements ICategoryService {
    @Autowired
    ICategoryRepository repository;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Category findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
