package com.araxsys.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.araxsys.domain.Category;
import com.araxsys.services.CategoryService;

@Controller
public class CategoryController {
private CategoryService categoryService;
	
	@Autowired
    public void setUserService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

	@RequestMapping("/categories")
	public String list(Model model){
		model.addAttribute("categories", categoryService.listAllCategories());
		model.addAttribute("saveCategory",new Category());
		return "categories";
	}
	
	@RequestMapping(value="/categories",params={"selected"})
	public String delete(Model model,HttpServletRequest req){
		model.addAttribute("categories", categoryService.listAllCategories());
		model.addAttribute("saveCategory",new Category());
		categoryService.deleteCategory(Integer.parseInt(req.getParameter("selected")));
		
		return "redirect:categories";
	}
	
	@RequestMapping(value="/categories",params={"saveCategory"})
	public String save(@ModelAttribute Category saveCategory,Model model){
		model.addAttribute("categories", categoryService.listAllCategories());
		model.addAttribute("saveCategory",new Category());
		categoryService.saveCategory(saveCategory);
		
		return "redirect:categories";
	}
	
	@RequestMapping("/categoryName/{categoryName}")
	public String showCategoryByName(@PathVariable String categoryName, Model model){
		model.addAttribute("category",categoryService.getCategoryByName(categoryName));
		return "category";
	}
	
	@RequestMapping("/categoryId/{categoryId}")
	public String showCategoryById(@PathVariable int categoryId, Model model){
		model.addAttribute("category",categoryService.getCategoryById(categoryId));
		return "category";
	}
	
}
