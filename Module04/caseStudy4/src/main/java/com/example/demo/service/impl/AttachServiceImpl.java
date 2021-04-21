package com.example.demo.service.impl;

import com.example.demo.model.AttachService;
import com.example.demo.repository.AttachServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepo attachServiceRepo;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepo.findAll();
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepo.save(attachService);
    }


}
