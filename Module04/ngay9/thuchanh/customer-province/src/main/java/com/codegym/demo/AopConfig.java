package com.codegym.demo;

import com.codegym.demo.aop.CusAop;
import com.codegym.demo.service.impl.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AopConfig {
    @Bean
    public CustomerServiceImpl customerService(){
        return new CustomerServiceImpl();
    }
    @Bean
    public CusAop cusAop(){
        return new CusAop();
    }
}
