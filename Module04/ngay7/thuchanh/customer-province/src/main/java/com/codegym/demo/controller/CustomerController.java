package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/")
    public ModelAndView getCustomerList(@PageableDefault(2)Pageable pageable) {
        return new ModelAndView("list", "customers", customerService.findAll(pageable));
    }

    @GetMapping("/customer/create")
    public String showCreateForm(Model model) {
        model.addAttribute("provinces", provinceService.findAll());
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/customer/save")
    public String createNewCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String showEditForm(Model model, @PathVariable Integer id) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("provinces",provinceService.findAll());
        return "edit";

    }

    @PostMapping("/customer/update")
    public String editCustomer(Customer customer) {
        this.customerService.save(customer);
        return "redirect:/";
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer(@RequestParam Integer id) {
        customerService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/customer/view")
    public String viewCustomer(@RequestParam Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }

}
