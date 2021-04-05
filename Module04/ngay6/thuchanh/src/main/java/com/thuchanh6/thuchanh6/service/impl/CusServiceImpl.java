package com.thuchanh6.thuchanh6.service.impl;

import com.thuchanh6.thuchanh6.model.Customer;
import com.thuchanh6.thuchanh6.repositoy.ICusRepo;
import com.thuchanh6.thuchanh6.service.ICusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CusServiceImpl implements ICusService {
    @Autowired
    ICusRepo cusRepo ;

    @Override
    public List<Customer> findAll() {
        return cusRepo.findAll();
    }

    @Override
    public Customer findById(int id) {
        return cusRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        cusRepo.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        cusRepo.save(customer);
    }
}
