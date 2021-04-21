package com.example.demo.service;


import com.example.demo.model.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();
    EducationDegree findById(int id);
    void save(EducationDegree educationDegree);
    void remove(int id);
}
