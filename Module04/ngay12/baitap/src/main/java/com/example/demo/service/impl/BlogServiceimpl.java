package com.example.demo.service.impl;



import com.example.demo.common.Util;
import com.example.demo.model.Blog;
import com.example.demo.reposity.IBlogRepo;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceimpl implements IBlogService {
    @Autowired
    IBlogRepo iBlogRepo;


    @Override
    public List<Blog> findAll( ) {
        return iBlogRepo.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null){
            blog.setPostDay(Util.getCurrentDay());
        }
        iBlogRepo.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        iBlogRepo.deleteById(id);
    }

    @Override
    public List<Blog> findByTitle( String keyword) {
        return iBlogRepo.findAllByTitle(keyword);
    }

    @Override
    public List<Blog> sort( ) {
        return iBlogRepo.findByOrderByTitleDesc();
    }

}
