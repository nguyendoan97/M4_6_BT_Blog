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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class AccountController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public ModelAndView getIndex(){
        Iterable<Account> accounts = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView("/account/list");
        modelAndView.addObject("accounts",accounts);
        return modelAndView;
    }

    @GetMapping("/account/reg")
    public ModelAndView createAccount(){
        ModelAndView modelAndView = new ModelAndView("/account/create");
        modelAndView.addObject("accounts",new Account());
        return modelAndView;
    }

    @PostMapping("/account/reg")
    public ModelAndView saveAccount(@ModelAttribute("accounts")Account account){
        accountService.save(account);
        ModelAndView modelAndView = new ModelAndView("/account/create");
        modelAndView.addObject("accounts",new Account());
        modelAndView.addObject("message","Create account successfully");
        return modelAndView;
    }
}
