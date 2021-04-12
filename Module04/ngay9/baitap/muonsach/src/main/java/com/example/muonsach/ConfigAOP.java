package com.example.muonsach;

import com.example.muonsach.aop.AOPBook;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigAOP {

    @Bean
    public AOPBook createObjAOPBook() {
        return new AOPBook();
    }
}
