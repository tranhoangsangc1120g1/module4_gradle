package com.thuchanh6.thuchanh6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String getList(){
        return "/list";
    }
}
