package com.sang.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImp implements ICalculatorService {

    @Override
    public float returnResult(float a, float b, char character) {
        float c = 0;
        switch (character) {
            case '+':
                return c = (a + b);
            case '-':
                return c = (a - b);
            case '*':
                return c = (a * b);
            case '/':
                    return c = (a / b);
        }
        return c;
    }
}