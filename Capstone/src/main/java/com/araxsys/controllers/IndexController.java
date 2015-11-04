package com.araxsys.controllers;

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
    String index(Model model){
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
