package com.example.baitap.service;

import com.example.baitap.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICusService  {

    void save(Customer customer);

    void deleteById(Integer id);
}
