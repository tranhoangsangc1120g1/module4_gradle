package com.example.demo.repository;

import com.example.demo.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepo extends JpaRepository<Contract,Integer> {
}
