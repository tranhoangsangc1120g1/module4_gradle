package com.example.baitap7.controller;

import com.example.baitap7.model.Category;
import com.example.baitap7.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/category")
    public ModelAndView getCategoryList(@PageableDefault(value = 2)Pageable pageable){
        return new ModelAndView("/category/list","listCategory",categoryService.findAll(pageable));
    }

    @GetMapping("/create_category")
    public ModelAndView showCreateFormCategory(){
        return new ModelAndView("/category/create", "category", new Category());
    }

    @PostMapping("/create_category")
    public String createCategory(Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("message", "Create successfully ");
        return "redirect:/category";
    }

    @GetMapping("/view_category")
    public String viewCategory(@RequestParam Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/category/view";
    }

    @GetMapping("/show_edit")
    public String showEditFormCategory(@RequestParam Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/category/edit";
    }

    @PostMapping("/edit_category")
    public String editCategory(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("message", "Update Successfully");
        return "redirect:/category";
    }

    @PostMapping("/delete_category")
    public String deleteCategory(@RequestParam Integer id, RedirectAttributes redirect) {
        categoryService.deleteById(id);
        redirect.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/category";
    }
}
