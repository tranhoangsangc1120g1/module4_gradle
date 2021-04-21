package com.example.demo.service;

import com.example.demo.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    Position findById(int id);
    void save(Position position);
    void remove(int id);
}
