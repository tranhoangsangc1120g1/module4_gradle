package com.example.demo.service;


import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    void save(Contract contract);
}
