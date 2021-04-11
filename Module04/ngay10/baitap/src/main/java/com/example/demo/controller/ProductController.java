package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@SessionAttributes(names = "cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }
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
//        if (product==null){
//            modelAndView.addObject("message","Error");
//        }else{
//            modelAndView.addObject("product",product);
//
//        }
        cart.addToCart(product);
        modelAndView.addObject("message","Add to cart successfully\nAmount:");
        modelAndView.addObject("mapCart",cart.getCart());
        return modelAndView;
    }
    @GetMapping("/deleted")
    public ModelAndView deletedProductInCart(@RequestParam(name = "id") int id,Cart cart){
        cart.removeProduct(productService.findById(id));
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("mess","Deleted Successfully");
        return modelAndView;
    }


    @GetMapping("/cart")
    public ModelAndView showCart(@ModelAttribute("cart")Cart cart){
        return new ModelAndView("listCart","mapCart",cart.getCart());
    }
}
