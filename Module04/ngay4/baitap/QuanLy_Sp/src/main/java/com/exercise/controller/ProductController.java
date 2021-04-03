package com.exercise.controller;

import com.exercise.model.Product;
import com.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("/")
    public String getHome(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }
    @GetMapping("/products/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/products/save")
    public String save(Product product ,RedirectAttributes redirect) {
        product.setId((int)(Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "ADD product successfully!");
        return "redirect:/";
    }
    @GetMapping("/products/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/products/update")
    public String update(Product product , RedirectAttributes redirect) {
        redirect.addFlashAttribute("success", "Edit product successfully!");
        productService.update(product.getId(), product);
        return "redirect:/";
    }
    @PostMapping("/products/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }
    @GetMapping("/products/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
