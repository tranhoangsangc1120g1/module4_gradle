package com.example.muonsach.service;

import org.springframework.stereotype.Service;

@Service
public interface ICounterService {
     int getCounter(int id);
     void getVisitCount(int  id);
}
