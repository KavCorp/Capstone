package com.araxsys.controllers;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.araxsys.services.CategoryService;

import com.araxsys.domain.Category;
import com.araxsys.domain.Department;
import com.araxsys.domain.PositionIndex;
import com.araxsys.domain.Positions;
import com.araxsys.domain.PositionsCompositePK;

import com.araxsys.services.DepartmentService;
import com.araxsys.services.PositionIndexService;
import com.araxsys.services.PositionsService;
import com.araxsys.services.UserService;


@Controller
public class DepartmentsController {
	private CategoryService categoryService;
	private DepartmentService departmentService;
	private UserService userService;
	private PositionIndexService positionIndexService;
	private PositionsService positionsService;
	
	@Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
	@Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
	
	@Autowired
    public void setPositionIndexService(PositionIndexService positionIndexService) {
        this.positionIndexService = positionIndexService;
    }
	
	@Autowired
    public void setPositionService(PositionsService positionsService) {
        this.positionsService = positionsService;
    }
	
	@RequestMapping(value="/admin/departments",method=RequestMethod.GET)
	public String listDepartments(Model model){
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("departments", departmentService.listAllDepartments());
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("saveDepartment",new Department());
		model.addAttribute("fieldSetText","New Department");
		
		return "departments";
	}
	
	@RequestMapping(value="/admin/departments",params={"saveDepartment"},method=RequestMethod.POST)
	public String saveDepartment(@ModelAttribute Department saveDepartment, Model model){
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("departments", departmentService.listAllDepartments());
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("saveDepartment",new Department());
		model.addAttribute("fieldSetText","New Department");
		
		departmentService.saveDepartment(saveDepartment);
		return "redirect:departments";
	}
	
	@RequestMapping(value="/admin/departments/update", params={"selected"},method=RequestMethod.GET)
	public String updateDepartment(Model model, HttpServletRequest req){
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("departments", departmentService.listAllDepartments());
		model.addAttribute("saveDepartment",departmentService.getDepartmentById(Integer.parseInt(req.getParameter("selected"))));
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("fieldSetText","Update Department");
		return "departments";
	}
	
	@RequestMapping(value="/admin/departments", params={"selected"},method=RequestMethod.POST)
	public String deleteDepartment(Model model, HttpServletRequest req){
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("departments", departmentService.listAllDepartments());
		model.addAttribute("saveDepartment",new Department());
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("fieldSetText","New Department");
		
		departmentService.deleteDepartment(Integer.parseInt(req.getParameter("selected")));
		return "redirect:departments";
	}
	
	@RequestMapping(value="/admin/department/{departmentName}")
	public String showDepartment(Model model,@PathVariable String departmentName){
		Department thisDepartment = departmentService.getDepartmentByName(departmentName);
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("thisDepartment",thisDepartment);
		model.addAttribute("deptPositions",positionIndexService.getPositionsByDepartment(departmentName));
		model.addAttribute("deptRoster",positionsService.getPositionsByDepartment(thisDepartment));
		model.addAttribute("users",userService.listAllUsers());
		model.addAttribute("savePositionIndex", new PositionIndex());
		model.addAttribute("savePosition", new Positions());
		model.addAttribute("fieldSetText1","Add User");
		model.addAttribute("fieldSetText2","New Position");
		return "department";
	}
	
	@RequestMapping(value="/admin/department/{departmentName}",params={"savePosition"},method = RequestMethod.POST)
	public String saveUserToDepartment(@ModelAttribute Positions savePosition ,Model model,@PathVariable String departmentName){
		Department thisDepartment = departmentService.getDepartmentByName(departmentName);
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("thisDepartment",thisDepartment);
		model.addAttribute("deptPositions",positionIndexService.getPositionsByDepartment(departmentName));
		model.addAttribute("deptRoster",positionsService.getPositionsByDepartment(thisDepartment));
		model.addAttribute("users",userService.listAllUsers());
		model.addAttribute("savePositionIndex", new PositionIndex());
		model.addAttribute("savePosition", new Positions());
		model.addAttribute("fieldSetText1","Add User");
		model.addAttribute("fieldSetText2","New Position");
		positionsService.savePositions(savePosition);
		return "redirect:"+thisDepartment.getDepartmentName();
	}
	
	@RequestMapping(value="/admin/department/{departmentName}/roster",params={"selected"},method = RequestMethod.GET)
	public String updateUserToDepartment(Model model,@PathVariable String departmentName,HttpServletRequest req){
		Department thisDepartment = departmentService.getDepartmentByName(departmentName);
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("thisDepartment",thisDepartment);
		model.addAttribute("deptPositions",positionIndexService.getPositionsByDepartment(departmentName));
		model.addAttribute("deptRoster",positionsService.getPositionsByDepartment(thisDepartment));
		model.addAttribute("users",userService.listAllUsers());
		model.addAttribute("savePositionIndex", new PositionIndex());
		PositionsCompositePK myKey = new PositionsCompositePK();
		myKey.setDepartmentId(thisDepartment);
		myKey.setUsername(req.getParameter("selected"));
		model.addAttribute("savePosition", positionsService.getPositionsById(myKey));
		model.addAttribute("fieldSetText1","Update User");
		model.addAttribute("fieldSetText2","New Position");
		return "department";
	}
	
	@RequestMapping(value="/admin/department/{departmentName}/roster",params="selected",method=RequestMethod.POST)
	public String deleteUserFromDepartment(Model model,@PathVariable String departmentName,HttpServletRequest req){
		Department thisDepartment = departmentService.getDepartmentByName(departmentName);
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("thisDepartment",thisDepartment);
		model.addAttribute("deptPositions",positionIndexService.getPositionsByDepartment(departmentName));
		model.addAttribute("deptRoster",positionsService.getPositionsByDepartment(thisDepartment));
		model.addAttribute("users",userService.listAllUsers());
		model.addAttribute("savePositionIndex", new PositionIndex());
		model.addAttribute("savePosition", new Positions());
		model.addAttribute("fieldSetText1","Add User");
		model.addAttribute("fieldSetText2","New Position");
		PositionsCompositePK myKey = new PositionsCompositePK();
		myKey.setDepartmentId(thisDepartment);
		myKey.setUsername(req.getParameter("selected"));
		positionsService.deletePositions(myKey);
		return "redirect:";
	}
	
	@RequestMapping(value="/admin/department/{departmentName}/position",params={"savePositionIndex"},method = RequestMethod.POST)
	public String savePositionToDepartment(@ModelAttribute PositionIndex savePositionIndex ,Model model,@PathVariable String departmentName){
		Department thisDepartment = departmentService.getDepartmentByName(departmentName);
		model.addAttribute("headerCats",categoryService.listAllCategories() );
		model.addAttribute("thisDepartment",thisDepartment);
		model.addAttribute("deptPositions",positionIndexService.getPositionsByDepartment(departmentName));
		model.addAttribute("deptRoster",positionsService.getPositionsByDepartment(thisDepartment));
		model.addAttribute("users",userService.listAllUsers());
		model.addAttribute("savePositionIndex", new PositionIndex());
		model.addAttribute("savePosition", new Positions());
		model.addAttribute("fieldSetText1","Add User");
		model.addAttribute("fieldSetText2","New Position");
		positionIndexService.savePositionIndex(savePositionIndex);
		return "redirect:";
	}

}
