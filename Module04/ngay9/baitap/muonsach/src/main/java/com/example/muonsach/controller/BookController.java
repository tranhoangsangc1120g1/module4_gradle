package com.example.muonsach.controller;

import com.example.muonsach.model.Book;
import com.example.muonsach.service.BookException;
import com.example.muonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @GetMapping("/book")
    public ModelAndView getHome(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("list","listBook",bookService.findAll(pageable));
    }

    @GetMapping("/borrowed")
    public ModelAndView getBorrowed (Book book,Pageable pageable) throws BookException {
        bookService.saveBorrowed(book.getId());
        ModelAndView modelAndView =new ModelAndView("list");
        modelAndView.addObject("listBook",bookService.findAll(pageable));
        modelAndView.addObject("mess","Borrowed Successfully");
        return modelAndView;

    }
    @ExceptionHandler(BookException.class)
    public ModelAndView showException(){
        return new ModelAndView("result");
    }
    @GetMapping("/return")
    public ModelAndView getReturn (Book book,Pageable pageable)  {
        bookService.saveReturn(book.getId());
        ModelAndView modelAndView =new ModelAndView("list");
        modelAndView.addObject("listBook",bookService.findAll(pageable));
        modelAndView.addObject("mess","Return Successfully");
        return modelAndView;
    }
}
