package com.example.demo.repositoy;


import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICusRepo extends JpaRepository<Customer,Integer> {
}
