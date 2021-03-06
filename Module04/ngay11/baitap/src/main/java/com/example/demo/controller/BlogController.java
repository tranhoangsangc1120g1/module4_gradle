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

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/blog")
    public ModelAndView getHomeAdmin(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam(name = "sortby") Optional<String> sortby) {
        Page<Blog> listBlog;

//        if (sortby.isPresent()) {
//            if (sortby.get().equals("desc")) {
//                Pageable pageSortByTitle = PageRequest.of(pageable.getPageNumber(), 3, Sort.by("title").descending());
//            }
//        }

        ModelAndView modelAndView =new ModelAndView("list");
//        modelAndView.addObject("sortby",sortby);
        modelAndView.addObject("listBlog",blogService.sort(pageable));
//         modelAndView.addObject("listBlog",listBlog);
        return modelAndView;
    }

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

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirect) {
        blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/blog";
    }
    @GetMapping("/search_blog")
    public ModelAndView searchBlog( @RequestParam(name = "keyword") Optional<String> keyword,Pageable pageable){
       Page<Blog> listBlog;
        if (keyword.isPresent()) {
            listBlog = blogService.findAllByTitleContaining(pageable,keyword.get());
        } else {
            listBlog = blogService.findAll(pageable);
        }
        return new ModelAndView("list","listBlog",listBlog);
    }

}
