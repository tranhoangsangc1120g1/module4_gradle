package com.example.demo.repository;

import com.example.demo.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepo extends JpaRepository<ServiceType,Integer> {
}
