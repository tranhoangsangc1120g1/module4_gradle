package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    PositionService positionService;

    @Autowired
    EducationDegreeService educationDegreeService;

    @Autowired
    UserService userService;

    @GetMapping("/list_employee")
    public ModelAndView showListCustomer(Pageable pageable) {
        return new ModelAndView("/employee/list", "employeeList", employeeService.findAll(pageable));
    }

    @GetMapping("/create_employee")
    public ModelAndView showCreateForm(Employee employee, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("employeeList", employeeService.findAll(pageable));
        modelAndView.addObject("divisionList", divisionService.findAll());
        modelAndView.addObject("positionList", positionService.findAll());
        modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
        modelAndView.addObject("user", userService.findAll());
        return modelAndView;
    }
   @PostMapping("/create_employee")
    public String createEmployee(Employee employee ,RedirectAttributes redirect){
        employeeService.save(employee);
        redirect.addFlashAttribute("message","Create Successfully");
        return "redirect:/employee/list_employee";
    }

    @GetMapping("/edit_employee")
    public ModelAndView showEditForm(@RequestParam int id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/edit", "employee", employeeService.findById(id));
        modelAndView.addObject("employeeList", employeeService.findAll(pageable));
        modelAndView.addObject("divisionList", divisionService.findAll());
        modelAndView.addObject("positionList", positionService.findAll());
        modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
        modelAndView.addObject("user", userService.findAll());
        return modelAndView;
    }
    @PostMapping("/edit_employee")
    public String editEmployee(Employee employee ,RedirectAttributes redirect){
        employeeService.save(employee);
        redirect.addFlashAttribute("message","Edit Successfully");
        return "redirect:/employee/list_employee";
    }

    @PostMapping("/delete_employee")
    public String deleteEmployee(@RequestParam int id, RedirectAttributes redirect) {
        employeeService.remove(id);
        redirect.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/employee/list_employee";
    }
    @GetMapping("/search_employee")
    public ModelAndView searchEmployee(@RequestParam(name = "name") String name,Pageable pageable){
        Page<Employee> employeeList;
        ModelAndView modelAndView =new ModelAndView("/employee/list");
        modelAndView.addObject("name",name);

        if (name.trim().equals("")){
            employeeList = employeeService.findAll(pageable);
        } else{
            employeeList=employeeService.searchByName(name,pageable);
        }

        modelAndView.addObject("employeeList",employeeList);

        return modelAndView;
    }
}
