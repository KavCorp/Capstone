package com.araxsys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
    @RequestMapping("/lock")
    String index2(){
        return "index2";
    }
    @RequestMapping("/home")
    String home(){
        return "home";
    }
    @RequestMapping("/register")
    String register(){
        return "register";
    }
}
