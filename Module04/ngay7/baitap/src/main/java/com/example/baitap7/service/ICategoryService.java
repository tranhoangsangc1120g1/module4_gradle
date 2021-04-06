package com.example.baitap7.service;

import com.example.baitap7.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
