package com.example.baitap.repository;

import com.example.baitap.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICusRepo extends JpaRepository<Customer,Integer> {

}
