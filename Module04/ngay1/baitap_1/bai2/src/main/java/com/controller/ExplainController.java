package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ExplainController {
    @GetMapping("/")
    public String input() {
        return "words";
    }

    @PostMapping("/search")
    public String translation(@RequestParam String vocabulary, Model model) {
        Map<String, String> searchList = new HashMap<>();
        searchList.put("yes", "no");
        searchList.put("no", "yes");
        String mess = "không tìm thấy";
        String result= searchList.get(vocabulary);
        model.addAttribute("vocabulary",vocabulary);
        if (result !=null){
            model.addAttribute("result",result);
            return "result";
        }else {
            model.addAttribute("mess",mess);
            return "words";
        }
    }
}
