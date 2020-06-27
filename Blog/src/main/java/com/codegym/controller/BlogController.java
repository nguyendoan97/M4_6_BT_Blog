package com.codegym.controller;


import com.codegym.model.Account;
import com.codegym.model.Blog;
import com.codegym.service.AccountService;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private AccountService accountService;

    @ModelAttribute("accounts")
    public Iterable<Account> accounts(){
        return accountService.findAll();
    }

    @GetMapping("/")
    public ModelAndView getIndex(@RequestParam("s") Optional<String> s, @PageableDefault(size = 3) Pageable pageable){
        Page<Blog> blogs;
        if(s.isPresent()){
            blogs = blogService.findAllByTitle(s.get(),pageable);
        }else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }

    @GetMapping("/blog/create")
    public ModelAndView createPost(){
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blogs",new Blog());
        return modelAndView;
    }

    @PostMapping("/blog/create")
    public ModelAndView savePost(@ModelAttribute("blog")Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blogs",new Blog());
        modelAndView.addObject("message","Create post successfully");
        return modelAndView;
    }

    @GetMapping("/blog/{id}/edit")
    public ModelAndView edit(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null){
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog",blog);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/blog/edit")
    public ModelAndView edit(@ModelAttribute("blog")Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","Update post successfully");
        return modelAndView;
    }

}
