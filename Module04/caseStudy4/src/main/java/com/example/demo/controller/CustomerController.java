package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;
    @GetMapping("/list_customer")
    public ModelAndView showCustomerList(@PageableDefault(value =2) Pageable pageable){
        return new ModelAndView("/customer/list","customerList",customerService.findAll(pageable));
    };

    @GetMapping("/create_customer")
    public ModelAndView showCreateForm(Customer customer, Pageable pageable){
            ModelAndView modelAndView =  new ModelAndView("/customer/create");
            modelAndView.addObject("customer",customer);
            modelAndView.addObject("customerTypeList",customerTypeService.findAll(pageable));
        return  modelAndView;
    }
    @PostMapping("/create_customer")
    public String createCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Create successfully ");
        return "redirect:/customer/list_customer";
    }
    @GetMapping("/edit_customer")
    public ModelAndView showEditForm(@RequestParam String id,Pageable pageable){
        ModelAndView modelAndView =new ModelAndView("/customer/edit","customer",customerService.findById(id));
        modelAndView.addObject("customerTypeList",customerTypeService.findAll(pageable));
        return modelAndView;
    }
    @PostMapping("/edit_customer")
    public String editCustomer(Customer customer,RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Edit successfully ");
        return "redirect:/customer/list_customer"   ;
    }
    @GetMapping("/delete_customer")
    public String deleteCustomer(@RequestParam String id ,RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("mess","Deleted Successfully");
        return "redirect:customer/list_customer";
    }
}
