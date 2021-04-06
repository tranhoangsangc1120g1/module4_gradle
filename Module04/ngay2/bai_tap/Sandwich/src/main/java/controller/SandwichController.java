package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String getFormOptions() {
        return "optionslist";
    }

    @GetMapping("/save")
    public String save(@RequestParam String[] condiment, Model model) {
//        model.addAttribute("condiment", Arrays.toString(condiment));
        model.addAttribute("condiment", condiment);
        return "optionslist";
    }
}
