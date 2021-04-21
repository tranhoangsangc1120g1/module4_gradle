package com.example.demo.service;


import com.example.demo.model.Division;

import java.util.List;

public interface DivisionService {
    List<Division> findAll();
    Division findById(int id);
    void save(Division division);
    void remove(int id);
}
