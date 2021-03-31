package com.sang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sang.service.ICalculatorService;

@Controller

public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String getCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam float a, @RequestParam float b
            , @RequestParam char character, Model model) {
            model.addAttribute("a", a);
            model.addAttribute("b", b);
            model.addAttribute("character", character);
            try{
                model.addAttribute("c", iCalculatorService.returnResult(a,b,character));
            }catch (ArithmeticException e){
                model.addAttribute("error",e.getMessage());
            }

         return "calculator";
    }
}
