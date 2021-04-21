package com.example.demo.service.impl;

import com.example.demo.repository.ServiceRepo;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepo serviceRepo;

    @Override
    public Page<com.example.demo.model.Service> findAll(Pageable pageable) {
        return serviceRepo.findAll(pageable);
    }

    @Override
    public com.example.demo.model.Service findById(String id) {
        return serviceRepo.findById(id).orElse(null);
    }

    @Override
    public void save(com.example.demo.model.Service service) {
        serviceRepo.save(service);
    }

    @Override
    public void remove(String id) {
        serviceRepo.deleteById(id);
    }
}
