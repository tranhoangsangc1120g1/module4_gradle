package com.example.demo.service;


import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




public interface IBlogService  {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void deleteById(Integer id);

    Page<Blog> findAllByTitleContaining(Pageable pageable,String keyword);


}
