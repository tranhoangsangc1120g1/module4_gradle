package com.example.muonsach.service.impl;

import com.example.muonsach.model.Counter;
import com.example.muonsach.repository.ICounterRepo;
import com.example.muonsach.service.ICounterService;
import org.springframework.beans.factory.annotation.Autowired;

public class CounterServiceImpl  implements ICounterService {
    @Autowired
    ICounterRepo counterRepo;
    @Override
    public int getCounter(int  id) {
        Counter counter= counterRepo.getOne(id);
         return counter.getCount();
    }

    @Override
    public void getVisitCount(int  id) {
        Counter counter = counterRepo.getOne(id);
        counter.setCount(counter.getCount()+1);
        counterRepo.save(counter);
    }
}
