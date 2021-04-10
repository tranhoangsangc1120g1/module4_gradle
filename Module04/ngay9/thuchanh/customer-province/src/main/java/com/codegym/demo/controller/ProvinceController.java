package com.codegym.demo.controller;

import com.codegym.demo.model.Province;
import com.codegym.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    @GetMapping("/province")
    public ModelAndView getHomePage() {
        List<Province> provinceList = provinceService.findAll();
        return new ModelAndView("listProvince", "provinces", provinceList);
    }

    @GetMapping("/province/edit")
    public ModelAndView showCreateForm(Integer id) {
        return new ModelAndView("createProvince", "provinces", provinceService.findById(id));
    }

    @PostMapping("/province/save")
    public String createNewProvince(Province province) {
        provinceService.save(province);
        return "redirect:/province";
    }
}
