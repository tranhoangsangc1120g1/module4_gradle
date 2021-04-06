package com.example.baitap7.service;

import com.example.baitap7.model.Blog;

import java.util.List;

public interface IBlogService  {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteById(Integer id);
}
