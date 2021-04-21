package com.example.demo.service;


import com.example.demo.model.ContractDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailsService {
    Page<ContractDetails> findAll(Pageable pageable);
    void save(ContractDetails contractDetails);
}
