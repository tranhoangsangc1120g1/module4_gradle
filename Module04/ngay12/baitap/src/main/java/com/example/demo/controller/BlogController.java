package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/blog")
    public ModelAndView getHomeAdmin(@PageableDefault(value = 20) Pageable pageable) {
        return new ModelAndView("list","listBlog",blogService.findAll(pageable));
    };

    @GetMapping("/create_blog")
    public String showCreateForm(Model model, Pageable pageable) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.findAll(pageable));
        return "create";
    }

    @PostMapping("/create_blog")
    public String createArticle(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Create successfully ");
        return "redirect:/blog";
    }

    @GetMapping("/view")
    public String viewArticle(@RequestParam Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/view";
    }

    @GetMapping("/show_edit")
    public String showEditForm(@RequestParam Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/edit";
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Update Successfully");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public ModelAndView deleteForm(@RequestParam Integer id) {
        ModelAndView modelAndView=new ModelAndView("delete");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete_blog")
    public ModelAndView submitDelete(@RequestParam Integer id){
        blogService.deleteById(id);
        return new ModelAndView("list","mess","deleted Successfully");
    }

    @GetMapping("/search_blog")
    public String searchBlog( @RequestParam(name = "keyword") String keyword,Pageable pageable,Model model){
       Page<Blog> listBlog;
        if (keyword.trim().equals("")) {
            listBlog = blogService.findAll(pageable);

        } else {
            listBlog = blogService.findAllByTitleContaining(pageable,keyword);
        }
//        return new ModelAndView("/search::listBlog","listBlog",listBlog);
        model.addAttribute("listBlog",listBlog);
        return "/search::list-body";
    }

}
