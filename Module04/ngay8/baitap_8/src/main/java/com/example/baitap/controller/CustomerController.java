package com.example.baitap.controller;

import com.example.baitap.model.Customer;
import com.example.baitap.service.ICusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    ICusService cusService;
    @GetMapping("/create_cus")
    public String showCreateForm(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("/create_cus")
    public String createArticle(Integer id, RedirectAttributes redirect){
        cusService.deleteById(id);
        redirect.addFlashAttribute("message", "Create successfully ");
        return "redirect:/create_cus";
    }
}
