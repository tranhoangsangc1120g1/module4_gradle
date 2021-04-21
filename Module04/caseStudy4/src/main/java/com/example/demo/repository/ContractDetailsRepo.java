package com.example.demo.repository;

import com.example.demo.model.ContractDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailsRepo extends JpaRepository<ContractDetails,Integer> {
}
