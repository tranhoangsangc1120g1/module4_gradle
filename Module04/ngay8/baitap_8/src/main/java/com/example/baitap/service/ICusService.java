package com.example.baitap.service;

import com.example.baitap.model.Customer;


public interface ICusService  {

    void save(Customer customer);

    void deleteById(Integer id);
}
