package com.example.demo.service.impl;

import com.example.demo.model.RentType;
import com.example.demo.repository.RentTypeRepo;
import com.example.demo.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepo rentTypeRepo;


    @Override
    public List<RentType> findAll() {
        return rentTypeRepo.findAll();
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepo.save(rentType);
    }

    @Override
    public void remove(int id) {
        rentTypeRepo.deleteById(id);
    }
}
