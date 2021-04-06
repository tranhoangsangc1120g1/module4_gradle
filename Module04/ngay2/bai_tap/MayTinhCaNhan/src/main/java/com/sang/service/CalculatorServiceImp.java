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
                if (b != 0) {
                    return c = (a / b);
                } else {
                    throw new ArithmeticException("Tuổi trẻ ai cũng sẽ mắc những sai lầm , " +
                            "nhưng đem chia cho 0 thì không thể tha thứ được");
                }

        }
        return c;
    }
}