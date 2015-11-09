package com.araxsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.araxsys.domain.User;
import com.araxsys.services.CategoryService;

@Controller
public class IndexController {
	private CategoryService categoryService;
	@Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
	
    @RequestMapping("/")
    String index(Model model, @AuthenticationPrincipal User activeUser){
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
        return "index";
    }
    @RequestMapping("/lock")
    String index2(Model model){
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
        return "lock";
    }

  
    @RequestMapping("favicon.ico")
    String favicon() {
    	return "forward:/static/favicon.ico";
    }
    	    


}
