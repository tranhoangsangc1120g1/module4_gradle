package com.codegym.demo.service.impl;

import com.codegym.demo.model.Province;
import com.codegym.demo.repository.ProvinceRepository;
import com.codegym.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Integer id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }
}
