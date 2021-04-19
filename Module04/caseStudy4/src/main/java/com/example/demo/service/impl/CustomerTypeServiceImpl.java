package com.example.demo.service.impl;

import com.example.demo.model.CustomerType;
import com.example.demo.repository.CustomerTypeRepo;
import com.example.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepo customerTypeRepo;
    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepo.findAll(pageable);
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepo.save(customerType);
    }

    @Override
    public void remove(int id) {
        customerTypeRepo.deleteById(id);
    }
}
