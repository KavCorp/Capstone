package com.araxsys.controllers;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.araxsys.domain.User;
import com.araxsys.services.UserService;

@Controller
public class UserController {
	private UserService userService;

	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value = "/admin/users")
    public String list(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        model.addAttribute("users", userService.listAllUsers());
        System.out.println("Returning users:");
        return "Users";
    }
    @RequestMapping("profile/{username}")
    public String showProduct(@PathVariable String username, Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        model.addAttribute("user", userService.getUserByName(username));
        return "userprofile";
    }
    
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String register(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        model.addAttribute("register",new User());
        return "register";
    }
 
    @RequestMapping(value="/register",method=RequestMethod.POST,params={"register"})
    String register(@ModelAttribute User register, Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
    	userService.registerNewUserAccount(register);
        return "redirect:users";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		Model model) {

		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
			
		}


		return "login";

	}
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
    
    
    
    
    
    
    
    
    
    
    
}