package com.example.demo.controller;



import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@Controller
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

//    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Category> updateBlog(@PathVariable("id") int id, @RequestBody Category category) {
//        System.out.println("Updating category " + id);
//
//        Category currentCat = blogService.findById(id);
//
//        if (currentBlog == null) {
//            System.out.println("Customer with id " + id + " not found");
//            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
//        }
//
//        currentBlog.setAuthor(blog.getAuthor());
//        currentBlog.setCategory(blog.getCategory());
//        currentBlog.setContent(blog.getContent());
//        currentBlog.setDescription(blog.getDescription());
//        currentBlog.setImage(blog.getImage());
//        currentBlog.setTitle(blog.getTitle());
//        blogService.save(currentBlog);
//        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id) {
//        System.out.println("Fetching & Deleting Blog with id " + id);
//
//        Blog blog = blogService.findById(id);
//        if (blog == null) {
//            System.out.println("Unable to delete. Blog with id " + id + " not found");
//            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
//        }
//
//        blogService.deleteById(id);
//        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
//    }
}
