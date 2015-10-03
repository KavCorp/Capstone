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
        return "lock";
    }

    @RequestMapping("/register")
    String register(){
        return "register";
    }

}
