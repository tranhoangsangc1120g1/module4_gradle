package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICusRepo;
import com.example.demo.service.ICusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusServiceImpl implements ICusService {
    @Autowired
    ICusRepo cusRepo;
    @Override
    public List<Customer> findAll() {
        return cusRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return cusRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        cusRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
       cusRepo.deleteById(id);
    }
}
