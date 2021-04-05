package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.ICusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    ICusService cusService;

    @GetMapping("/customer")
    public ModelAndView customerList(){
        return new ModelAndView("/list","customerList", cusService.findAll());
    }
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/create","customer",new Customer());
    }
    @PostMapping("/create-customer")
    public ModelAndView saveCus(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("message","Created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Customer customer = cusService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-customer")
    public ModelAndView updateCus(@ModelAttribute("customer") Customer customer){
        cusService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", " updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        Customer customer = cusService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCus(@ModelAttribute("customer") Customer customer){
        cusService.deleteById(customer.getId());
        return "redirect:customers";
    }
}


