package com.sang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sang.service.ICalculatorService;

@Controller

public class Calculator {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String getCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam float a, @RequestParam float b
            , @RequestParam char character, Model model) {
        String mess = "tuổi trẻ ai cũng sẽ mắc những sai lầm , nhưng đem chia cho 0 thì không thể tha thứ được ";
        if (character == '/' && b == 0) {
            model.addAttribute("mess", mess);
        } else {
            model.addAttribute("a", a);
            model.addAttribute("b", b);
            model.addAttribute("character", character);
            float c = iCalculatorService.returnResult(a, b, character);
            model.addAttribute("c", c);
        } return "calculator";
    }
}
