package com.araxsys.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.araxsys.domain.Category;
import com.araxsys.domain.Department;
import com.araxsys.services.CategoryService;
import com.araxsys.services.DepartmentService;
import com.araxsys.services.UserService;


@Controller
public class DepartmentsController {
	private DepartmentService departmentService;
	private UserService userService;
	
	@Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
	
	@RequestMapping(value="/departments",method=RequestMethod.GET)
	public String listDepartments(Model model){
		model.addAttribute("departments", departmentService.listAllDepartments());
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("saveDepartment",new Department());
		model.addAttribute("fieldSetText","New Department");
		
		return "departments";
	}
	
	@RequestMapping(value="/departments",params={"saveDepartment"},method=RequestMethod.POST)
	public String saveDepartment(@ModelAttribute Department saveDepartment, Model model){
		model.addAttribute("departments", departmentService.listAllDepartments());
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("saveDepartment",new Department());
		model.addAttribute("fieldSetText","New Department");
		
		departmentService.saveDepartment(saveDepartment);
		return "redirect:departments";
	}
	
	@RequestMapping(value="/departments/update", params={"selected"},method=RequestMethod.GET)
	public String updateDepartment(Model model, HttpServletRequest req){
		model.addAttribute("departments", departmentService.listAllDepartments());
		model.addAttribute("saveDepartment",departmentService.getDepartmentById(Integer.parseInt(req.getParameter("selected"))));
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("fieldSetText","Update Department");
		return "departments";
	}
	
	@RequestMapping(value="/departments", params={"selected"},method=RequestMethod.POST)
	public String deleteDepartment(Model model, HttpServletRequest req){
		model.addAttribute("departments", departmentService.listAllDepartments());
		model.addAttribute("saveDepartment",new Department());
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("fieldSetText","New Department");
		
		departmentService.deleteDepartment(Integer.parseInt(req.getParameter("selected")));
		return "redirect:departments";
	}

}
