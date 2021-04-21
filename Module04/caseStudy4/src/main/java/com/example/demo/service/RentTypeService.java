package com.example.demo.service;


import com.example.demo.model.RentType;


import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();
    RentType findById(int id);
    void save(RentType rentType);
    void remove(int id);
}
