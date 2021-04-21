package com.example.demo.controller;

import com.example.demo.model.ContractDetails;
import com.example.demo.service.ContractDetailsService;
import com.example.demo.service.ContractService;
import com.example.demo.service.impl.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contractDetails")
public class ContractDetailsController {
    @Autowired
    AttachServiceService attachServiceService;

    @Autowired
    ContractService contractService;

    @Autowired
    ContractDetailsService contractDetailsService;

    @GetMapping("/create_form")
    public ModelAndView showCreateForm(ContractDetails contractDetails, Pageable pageable){
        ModelAndView modelAndView =new ModelAndView("/contractdetails/create");
        modelAndView.addObject("contractDetails",contractDetails);
        modelAndView.addObject("attachServiceList",attachServiceService.findAll());
        modelAndView.addObject("contractList",contractService.findAll(pageable));
       return modelAndView;
    };

    @PostMapping("/create_contractDetails")
    public String createContract(ContractDetails contractDetails, RedirectAttributes redirect){
        contractDetailsService.save(contractDetails);
        redirect.addFlashAttribute("message","Create Successfully");
        return "redirect:/contractDetails/create_form";
    };

}
