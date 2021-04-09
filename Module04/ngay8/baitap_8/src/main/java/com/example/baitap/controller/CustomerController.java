package com.example.baitap.controller;

import com.example.baitap.model.Customer;
import com.example.baitap.service.ICusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    ICusService cusService;
    @GetMapping("/create_cusform")
    public String showCreateForm(Model model ){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/validate")
    public ModelAndView checkValidation(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        cusService.save(customer);
        ModelAndView modelAndView = new ModelAndView("result", "customer", customer);
        return modelAndView;
    }
    }

