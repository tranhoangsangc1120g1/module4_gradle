package com.example.demo.service.impl;

import com.example.demo.model.EducationDegree;
import com.example.demo.repository.EducationDegreeRepo;
import com.example.demo.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EducationServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepo educationDegreeRepo;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepo.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return null;
    }

    @Override
    public void save(EducationDegree educationDegree) {

    }

    @Override
    public void remove(int id) {

    }
}
