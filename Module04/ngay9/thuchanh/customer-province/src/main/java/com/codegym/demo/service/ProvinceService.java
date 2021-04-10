package com.codegym.demo.service;

import com.codegym.demo.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    Province findById(Integer id);
    void deleteById(Integer id);
    void save(Province province);
}
