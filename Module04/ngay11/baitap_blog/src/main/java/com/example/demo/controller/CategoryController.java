package com.example.demo.controller;


import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCustomers() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Cate " + category.getId());
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateBlog(@PathVariable("id") int id, @RequestBody Category category) {
        System.out.println("Updating category " + id);

        Category category1 = categoryService.findById(id);

        if (category1 == null) {
            System.out.println("category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        category1.getId();
        category1.getName();
        return new ResponseEntity<Category>(category1, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteBlog(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Blog with id " + id);

        Category category= categoryService.findById(id);
        if (category == null) {
            System.out.println("Unable to delete. category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        categoryService.deleteById(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}
