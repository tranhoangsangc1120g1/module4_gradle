package com.example.demo.service.impl;

import com.example.demo.model.ServiceType;
import com.example.demo.repository.ServiceTypeRepo;
import com.example.demo.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepo serviceTypeRepo;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepo.findAll();
    }

    @Override
    public ServiceType findById(int id) {
        return serviceTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepo.save(serviceType);
    }

    @Override
    public void remove(int id) {
        serviceTypeRepo.deleteById(id);
    }
}
