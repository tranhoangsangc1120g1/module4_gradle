package com.example.muonsach.aop;

import com.example.muonsach.service.ICounterService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class AOPBook {
    @Autowired
    ICounterService counterService;

    @After("execution(* com.example.muonsach.controller.BookController.getBorrowed(..))")
    public void afterBorrow(JoinPoint joinPoint){
        System.out.println("borrow successfully");
    }
    @After("execution(* com.example.muonsach.controller.BookController.getReturn(..))")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("return successfully");
    }

    @After("execution(* com.example.muonsach.controller.BookController.getHome(..))")
    public void afterVisit(JoinPoint joinPoint){
        System.out.println(counterService.getCounter(1));
    }

}
