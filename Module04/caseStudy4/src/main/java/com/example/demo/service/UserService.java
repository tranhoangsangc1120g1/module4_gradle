package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService  {
    List<User> findAll( );
    User findById(String id);
    void save(User user);
    void remove(String id);
}
