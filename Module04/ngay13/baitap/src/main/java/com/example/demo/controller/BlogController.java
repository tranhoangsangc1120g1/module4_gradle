package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/blog")
    public ModelAndView getHomeAdmin( ){
        return new ModelAndView("/list","listBlog",blogService.findAll());
    }

    @GetMapping("/create_blog")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/create", "blog", new Blog());
    }

    @PostMapping("/create_blog")
    public String createArticle(Blog blog, RedirectAttributes redirect){
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

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirect) {
        blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/blog";
    }
}
