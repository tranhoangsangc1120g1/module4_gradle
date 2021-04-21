package com.example.demo.service.impl;

import com.example.demo.model.Division;
import com.example.demo.repository.DivisionRepo;
import com.example.demo.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepo divisionRepo;


    @Override
    public List<Division> findAll() {
        return divisionRepo.findAll();
    }

    @Override
    public Division findById(int id) {
        return divisionRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {
        divisionRepo.save(division);
    }

    @Override
    public void remove(int id) {
        divisionRepo.deleteById(id);
    }
}
