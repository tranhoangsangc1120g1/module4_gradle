package com.example.muonsach.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AOPBook {
    @After("execution(* com.example.muonsach.controller.BookController.getBorrowed(..))")
    public void afterBorrow(JoinPoint joinPoint){
        System.out.println("borrow successfully");
    }
    @After("execution(* com.example.muonsach.controller.BookController.getReturn(..))")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("return successfully");
    }
}
