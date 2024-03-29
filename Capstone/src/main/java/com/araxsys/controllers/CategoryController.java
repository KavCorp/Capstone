package com.araxsys.controllers;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.araxsys.domain.Category;
import com.araxsys.domain.Page;
import com.araxsys.services.CategoryService;
import com.araxsys.services.PageService;



@Controller
public class CategoryController {
	private CategoryService categoryService;
	private PageService pageService;
	
	@Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
	
	@Autowired
    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

	@RequestMapping(value="/admin/categories",method=RequestMethod.GET)
	public String listCategories(Model model,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("categories", categoryService.listAllCategories());
		model.addAttribute("saveCategory",new Category());
		model.addAttribute("updateCategory", new Category());
		model.addAttribute("fieldSetText","New Category");
		
		return "categories";
	}
	
	@RequestMapping(value="/admin/categories/update", params={"selected"},method=RequestMethod.GET)
	public String updateCategory(Model model, HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("categories", categoryService.listAllCategories());
		model.addAttribute("saveCategory",categoryService.getCategoryById(Integer.parseInt(req.getParameter("selected"))));
		model.addAttribute("fieldSetText","Update Category");
		return "categories";
	}
	
	@RequestMapping(value="/admin/categories",params={"selected"},method=RequestMethod.POST)
	public String deleteCategory(Model model,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("categories", categoryService.listAllCategories());
		model.addAttribute("saveCategory",new Category());
		categoryService.deleteCategory(Integer.parseInt(req.getParameter("selected")));
		req.getSession().setAttribute("headerCats", null);
		return "redirect:categories";
	}
	
	@RequestMapping(value="/admin/categories",params={"saveCategory"},method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category saveCategory,Model model,HttpServletRequest req){
		model.addAttribute("categories", categoryService.listAllCategories());
		model.addAttribute("saveCategory",new Category());
		categoryService.saveCategory(saveCategory);
		req.getSession().setAttribute("headerCats", null);
		
		return "redirect:categories";
	}
	
	@RequestMapping(value="/admin/category/{categoryName}",method=RequestMethod.GET)
	public String showCategory(@PathVariable String categoryName, Model model,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("thisCategory",categoryService.getCategoryByName(categoryName));
		model.addAttribute("savePage",new Page());
		model.addAttribute("fieldSetText","New Page");
		
		return "category";
	}
	@RequestMapping(value="/admin/category/{categoryName}",method=RequestMethod.POST,params={"savePage"})
	public String savePageOnCategory( @PathVariable String categoryName, Model model,@ModelAttribute Page savePage,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("thisCategory",categoryService.getCategoryByName(categoryName));
		model.addAttribute("savePage",new Page());
		
		savePage = pageService.savePage(savePage);
		req.getSession().setAttribute("headerCats", null);
		return "redirect:"+categoryName;
	}
	
	@RequestMapping(value="/admin/category/{categoryName}",method=RequestMethod.POST,params={"selected"})
	public String deletePageOnCategory( @PathVariable String categoryName, Model model, HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("thisCategory",categoryService.getCategoryByName(categoryName));
		model.addAttribute("savePage",new Page());
		pageService.deletePage(Integer.parseInt(req.getParameter("selected")));
		req.getSession().setAttribute("headerCats", null);
		return "redirect:"+categoryName;
	}
	
	@RequestMapping(value="/admin/category/{categoryName}/update",method=RequestMethod.GET,params={"selected"})
	public String updatePageOnCategory(@PathVariable String categoryName, Model model, HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		String selected = req.getParameter("selected");
		model.addAttribute("thisCategory",categoryService.getCategoryByName(categoryName));
		model.addAttribute("savePage",pageService.getPage(Integer.parseInt(selected)));
		model.addAttribute("fieldSetText","Update Page");
		return "category";
	}
	
	
}
