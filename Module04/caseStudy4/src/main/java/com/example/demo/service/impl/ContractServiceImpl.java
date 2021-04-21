package com.example.demo.service.impl;

import com.example.demo.model.Contract;
import com.example.demo.repository.ContractRepo;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepo contractRepo;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepo.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepo.save(contract);
    }
}
