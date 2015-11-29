package com.araxsys.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.araxsys.services.CategoryService;



@Controller
public class IndexController {
	private CategoryService categoryService;
	@Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

	
    @RequestMapping("/")
    String index(Model model, HttpServletRequest req){
    	Principal principal = req.getUserPrincipal();
    	if(principal!=null){
    		req.getSession().setAttribute("headerCats", categoryService.listAllCategories() );
    	}
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        return "index";
    }
    @RequestMapping("/lock")
    String index2(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats")  );
        return "lock";
    }
    
    @RequestMapping("/contact")
    String contact(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        return "Contact";
    }
    
    @RequestMapping("/faq")
    String faq(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        return "FAQ";
    }
    
    

    @RequestMapping("/recruitment")
    String recruitment(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        return "Recruitment";
    }
    
    @RequestMapping("/rules")
    String rules(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        return "Rules";
    }
    @RequestMapping("/unitdetails")
    String unitdetails(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        return "Unitdetails";
    }
  
    @RequestMapping("favicon.ico")
    String favicon() {
    	return "forward:/static/favicon.ico";
    }
    	    


}
