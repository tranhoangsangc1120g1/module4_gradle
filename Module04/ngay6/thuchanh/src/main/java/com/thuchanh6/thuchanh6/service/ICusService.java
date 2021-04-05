package com.thuchanh6.thuchanh6.service;


import com.thuchanh6.thuchanh6.model.Customer;

import java.util.List;

public interface ICusService  {
    List<Customer> findAll();
    Customer findById(int id );
    void deleteById(int id);
    void save(Customer customer);
}
