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
    public String chuyenDoiTien(@RequestParam double uv, @RequestParam double vu, Model model) {
        double result1 = 23000 * uv;
        double result2 = vu / 23000;
        model.addAttribute("vnd", result1);
        model.addAttribute("usd", result2);
        return "result";
    }
}
