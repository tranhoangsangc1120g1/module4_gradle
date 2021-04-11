package com.example.demo.controller;

import com.example.demo.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names = "cart")
public class CartController {
    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }

    @GetMapping("/cart")
    public ModelAndView showCart(@ModelAttribute("cart")Cart cart){
        return new ModelAndView("listCart","mapCart",cart.getCart());
    }
}
