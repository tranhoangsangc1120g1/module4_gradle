package com.example.demo.controller;

import com.example.demo.model.Contract;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    ContractDetailsService contractDetailsService;



    @GetMapping("/create_form")
    public ModelAndView showCreateForm(Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("/contract/create",
                "contract",new Contract());
        modelAndView.addObject("employeeList",employeeService.findAll(pageable));
        modelAndView.addObject("customerList",customerService.findAll(pageable));
        modelAndView.addObject("serviceList",serviceService.findAll(pageable));
        modelAndView.addObject("contractDetailsList",contractDetailsService.findAll(pageable));
        return modelAndView;
    }
    @PostMapping("/create_contract")
    public String createNewContract(Contract contract, RedirectAttributes redirect){
        contractService.save(contract);
        redirect.addFlashAttribute("message","Create Successfully");
        return "redirect:/contract/create_form";
    };
}
