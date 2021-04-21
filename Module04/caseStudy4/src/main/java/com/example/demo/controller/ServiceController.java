package com.example.demo.controller;

import com.example.demo.model.Service;
import com.example.demo.service.RentTypeService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    RentTypeService rentTypeService;

    @GetMapping("/create_villa")
    public ModelAndView goCreateVilla(Service service){
    ModelAndView modelAndView =new ModelAndView("/service/createVilla");
    modelAndView.addObject("rentTypeList",rentTypeService.findAll());
    modelAndView.addObject("serviceTypeList",serviceTypeService.findAll());
    modelAndView.addObject("service",service);
    return modelAndView;
    }

    @PostMapping("/create_service_villa")
    public String createVilla(Service service , RedirectAttributes redirect){
        serviceService.save(service);
        redirect.addFlashAttribute("message","Create Successfully");
        return "redirect:/service/create_villa";
    }
    @GetMapping("/create_house")
    public ModelAndView goCreateHouse(Service service){
        ModelAndView modelAndView =new ModelAndView("/service/createHouse");
        modelAndView.addObject("rentTypeList",rentTypeService.findAll());
        modelAndView.addObject("serviceTypeList",serviceTypeService.findAll());
        modelAndView.addObject("service",service);
        return modelAndView;
    }

    @PostMapping("/create_service_house")
    public String createHouse(Service service , RedirectAttributes redirect){
        serviceService.save(service);
        redirect.addFlashAttribute("message","Create Successfully");
        return "redirect:/service/create_house";
    }

    @GetMapping("/create_room")
    public ModelAndView goCreateService(Service service){
        ModelAndView modelAndView =new ModelAndView("/service/createRoom");
        modelAndView.addObject("rentTypeList",rentTypeService.findAll());
        modelAndView.addObject("serviceTypeList",serviceTypeService.findAll());
        modelAndView.addObject("service",service);
        return modelAndView;
    }

    @PostMapping("/create_service_room")
    public String createService(Service service , RedirectAttributes redirect){
        serviceService.save(service);
        redirect.addFlashAttribute("message","Create Successfully");
        return "redirect:/service/create_room";
    }
}
