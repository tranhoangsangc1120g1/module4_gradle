package com.example.baitap.service.impl;

import com.example.baitap.model.Customer;
import com.example.baitap.repository.ICusRepo;
import com.example.baitap.service.ICusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CusServiceImpl  implements ICusService {
    @Autowired
    ICusRepo cusRepo;
    @Override
    public void save(Customer customer) {
        cusRepo.save(customer);
    }

    @Override
    public void deleteById(Integer id) {
        cusRepo.deleteById(id);
    }
}
