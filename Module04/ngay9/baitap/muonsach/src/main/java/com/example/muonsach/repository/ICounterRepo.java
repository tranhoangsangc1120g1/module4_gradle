package com.example.muonsach.repository;

import com.example.muonsach.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICounterRepo extends JpaRepository<Counter,Integer> {

}
