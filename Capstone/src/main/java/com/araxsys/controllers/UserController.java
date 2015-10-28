package com.araxsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.araxsys.domain.User;
import com.araxsys.services.UserService;

@Controller
public class UserController {
	private UserService userService;
	
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value = "/users")
    public String list(Model model){
        model.addAttribute("users", userService.listAllUsers());
        System.out.println("Returning users:");
        return "Users";
    }
    @RequestMapping("profile/{username}")
    public String showProduct(@PathVariable String username, Model model){
        model.addAttribute("user", userService.getUserByName(username));
        return "userprofile";
    }
    
    
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("register",new User());
        return "register";
    }
    
    
    
    
    @RequestMapping(value="/register",method=RequestMethod.POST,params={"register"})
    String register(@ModelAttribute User register, Model model){
    	User test = new User();
    	test.setUsername("testocles");
    	test.setPassword("testicle");
    	userService.saveUser(test);
        return "users";
    }
}