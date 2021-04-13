package com.example.demo.service;

import com.example.demo.model.Smartphone;

import java.util.List;

public interface SmartphoneService {
    List<Smartphone> findAll();
    Smartphone findById(Integer id);
    void save(Smartphone phone);
    void remove(Integer id);
}
