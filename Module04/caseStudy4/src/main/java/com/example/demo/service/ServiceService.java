package com.example.demo.service;


import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService  {
    Page<Service> findAll(Pageable pageable);
    Service findById(String id );
    void save(Service service);
    void remove(String id );
}
