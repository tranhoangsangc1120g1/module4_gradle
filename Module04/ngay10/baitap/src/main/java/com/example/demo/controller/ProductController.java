package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("/product")
    public ModelAndView getProductList(@PageableDefault(value = 2)Pageable page){
        return new ModelAndView("/product/list","listProduct",productService.findAllProduct(page));
    }

    @GetMapping("/view_product")
    public ModelAndView getProductInfo(@RequestParam Integer id){
        return new ModelAndView ("/product/view","product",productService.findById(id));
    }
    @PostMapping("/addtocart")
    public  ModelAndView addToCart(@RequestParam(name = "id") int id, Cart cart  ){
        Product product = productService.findById(id);
            ModelAndView modelAndView =new ModelAndView("listCart");
        if (product==null){
            modelAndView.addObject("message","Error");
        }else{
            modelAndView.addObject("product",product);
            cart.addToCart(product);
            modelAndView.addObject("message","Add to cart successfully\nAmount:");
        }
//        List<Product> listProduct = new ArrayList<>(cart.getCart().keySet());
//        modelAndView.addObject("listProduct",listProduct);
        modelAndView.addObject("mapcart",cart.getCart().keySet());


        return modelAndView;
    }
}
