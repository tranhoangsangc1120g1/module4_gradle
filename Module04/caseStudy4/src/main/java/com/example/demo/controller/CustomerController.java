package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ModelAndView showCustomerList(@PageableDefault(value =3) Pageable pageable){
        return new ModelAndView("/customer/list","customerList",customerService.findAll(pageable));
    };

    @GetMapping("/create_customer")
    public ModelAndView showCreateForm( Pageable pageable){
            ModelAndView modelAndView =  new ModelAndView("/customer/create");
            modelAndView.addObject("customer",new Customer());
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
    public String editCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Create successfully ");
        return "redirect:/customer/list_customer";
    }

    @PostMapping("/delete_customer")
    public String deleteCustomer(@RequestParam String id, RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/customer/list_customer";
    }
    @GetMapping("/search_customer")
    public ModelAndView searchCustomer(@RequestParam(name = "name") String name,Pageable pageable){
        Page<Customer> customerList;
        ModelAndView modelAndView =new ModelAndView("/customer/list");
        modelAndView.addObject("name",name);

        if (name.trim().equals("")){
            customerList = customerService.findAll(pageable);
        } else{
            customerList=customerService.searchByName(name,pageable);
        }

        modelAndView.addObject("customerList",customerList);

        return modelAndView;
    }
}
