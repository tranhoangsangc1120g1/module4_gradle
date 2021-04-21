package com.example.demo.service;


import com.example.demo.model.ServiceType;


import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll( );
    ServiceType findById(int id);
    void save(ServiceType serviceType);
    void remove(int id);
}
