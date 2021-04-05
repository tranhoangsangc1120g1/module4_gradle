package com.example.demo.service;


import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ICusService  {
    List<Customer> findAll();
    Customer findById(int id);
    void deleteById(int id);
    void save(Customer customer);
}
