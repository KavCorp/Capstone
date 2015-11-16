package com.araxsys.controllers;

import javax.servlet.http.HttpServletRequest;
import com.araxsys.domain.Category;
import com.araxsys.domain.Page;
import com.araxsys.services.CategoryService;
import com.araxsys.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PageController {
	private PageService pageService;
	private CategoryService categoryService;
	
	@Autowired
    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }
	
	@Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @RequestMapping(value = "/admin/pages",method=RequestMethod.GET)
    public String listPages(Model model){
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
        model.addAttribute("pages", pageService.listAllPages());
        model.addAttribute("categories",categoryService.listAllCategories());
        model.addAttribute("savePage", new Page());
        model.addAttribute("fieldSetText","New Page");
        return "pages";
    }
    
    @RequestMapping(value = "/admin/pages",params={"selected"},method=RequestMethod.POST)
    public String deletePage(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
        model.addAttribute("pages", pageService.listAllPages());
        model.addAttribute("categories",categoryService.listAllCategories());
        model.addAttribute("savePage", new Page());
        pageService.deletePage(Integer.parseInt(req.getParameter("selected")));
        return "redirect:pages";
    }
    
    @RequestMapping(value = "/admin/pages",params={"savePage"},method=RequestMethod.POST)
    public String savePage(Model model,@ModelAttribute Page savePage){
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
        model.addAttribute("pages", pageService.listAllPages());
        model.addAttribute("categories",categoryService.listAllCategories());
        model.addAttribute("savePage", new Page());
        pageService.savePage(savePage);
        return "redirect:pages";
    }
    
    @RequestMapping(value = "/admin/pages/update",params={"selected"},method=RequestMethod.GET)
    public String updatePage(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
        model.addAttribute("pages", pageService.listAllPages());
        model.addAttribute("categories",categoryService.listAllCategories());
        model.addAttribute("savePage", pageService.getPage(Integer.parseInt(req.getParameter("selected"))));
        model.addAttribute("fieldSetText","Update Page");
        return "pages";
    }
    
    @RequestMapping(value = "/page/{categoryName}/{pageName}", method=RequestMethod.GET)
    public String showPage(@PathVariable String categoryName, @PathVariable String pageName, Model model){
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
    	model.addAttribute("page",pageService.getPage(categoryName,pageName));
    	return "page"; 
    }
    
    @RequestMapping(value = "/page/{categoryName}/{pageName}", method=RequestMethod.PUT)
    public ResponseEntity<String> savePage(HttpServletRequest req,@PathVariable String categoryName, @PathVariable String pageName, Model model){
    	Page thisPage = pageService.savePage(pageService.getPage(categoryName,pageName));
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
    	model.addAttribute("page",thisPage);
    	System.out.println(req.getParameter("content"));
    	thisPage.setContent(req.getParameter("content"));
    	pageService.savePage(thisPage);
    	
    	return new ResponseEntity<String>("{'messages':'','errors':''}",HttpStatus.OK); 
    }
   
}