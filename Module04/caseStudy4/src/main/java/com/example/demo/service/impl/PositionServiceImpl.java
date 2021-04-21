package com.example.demo.service.impl;

import com.example.demo.model.Position;
import com.example.demo.repository.PositionRepo;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepo positionRepo;

    @Override
    public List<Position> findAll() {
        return positionRepo.findAll();
    }

    @Override
    public Position findById(int id) {
        return positionRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {
        positionRepo.save(position);
    }

    @Override
    public void remove(int id) {
        positionRepo.deleteById(id);
    }
}
