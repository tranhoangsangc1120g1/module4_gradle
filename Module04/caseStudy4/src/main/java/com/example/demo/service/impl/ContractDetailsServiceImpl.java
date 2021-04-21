package com.example.demo.service.impl;

import com.example.demo.model.ContractDetails;
import com.example.demo.repository.ContractDetailsRepo;
import com.example.demo.service.ContractDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailsServiceImpl implements ContractDetailsService {
    @Autowired
    ContractDetailsRepo contractDetailsRepo;

    @Override
    public Page<ContractDetails> findAll(Pageable pageable) {
        return contractDetailsRepo.findAll(pageable);
    }

    @Override
    public void save(ContractDetails contractDetails) {
        contractDetailsRepo.save(contractDetails);
    }
}
