package com.example.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ForePageController {

    @GetMapping(value="/")
    public String index(){
        return "redirect:home";
    }

    @GetMapping(value="/home")
    public String home(){
        return "admin/home";
    }

    @GetMapping(value = "/register")
    public String register(){
        return "admin/register";
    }

    @GetMapping(value="/registerSuccess")
    public String registerSuccess(){
        return "admin/registerSuccess";
    }

    @GetMapping(value="/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/forelogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:home";
    }

}
