package com.example.demo.repository;

import com.example.demo.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service,String> {
}
