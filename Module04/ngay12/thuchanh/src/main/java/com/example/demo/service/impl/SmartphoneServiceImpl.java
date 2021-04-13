package com.example.demo.service.impl;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import com.example.demo.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    SmartphoneRepository smartphoneRepository;
    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Smartphone phone) {
        smartphoneRepository.save(phone);
    }

    @Override
    public void remove(Integer id) {
         smartphoneRepository.deleteById(id);
    }
}
