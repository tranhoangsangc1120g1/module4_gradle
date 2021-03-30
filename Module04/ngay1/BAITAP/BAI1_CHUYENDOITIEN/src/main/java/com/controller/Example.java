package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Example {
    @GetMapping("/")
    public String example() {
        return "/example";
    }

    @PostMapping("/chuyendoi")
    public String convert(@RequestParam double uTv, @RequestParam double vTu, Model model) {
        double usdToVnd = 23000 * uTv;
        double vndToUsd = vTu / 23000;
        model.addAttribute("vnd", usdToVnd);
        model.addAttribute("usd", vndToUsd);
        return "result";
    }
}
