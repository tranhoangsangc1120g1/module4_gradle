package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String input() {
        return "words";
    }

    @PostMapping("/search")
    public String translation(@RequestParam String words, Model model) {
        Map<String, String> searchList = new HashMap<>();
        searchList.put("yes", "no");
        searchList.put("no", "yes");
        String mess = "Found not find";
        String result = searchList.get(words);
        model.addAttribute("words", words);
        if (result != null) {
            model.addAttribute("resultwords", result);
            return "result";
        } else {
            model.addAttribute("mess", mess);
            return "words";
        }
    }
}
