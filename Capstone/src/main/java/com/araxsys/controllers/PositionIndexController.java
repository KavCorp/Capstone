package com.araxsys.controllers;

import javax.servlet.http.HttpServletRequest;
import com.araxsys.domain.PositionIndex;
import com.araxsys.services.DepartmentService;
import com.araxsys.services.PositionIndexService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PositionIndexController {
	private PositionIndexService positionIndexService;
	private DepartmentService departmentService;
	
	@Autowired
	public void setPositionIndexController(PositionIndexService positionIndexService){
		this.positionIndexService = positionIndexService;
	}
	
	@Autowired
	public void setDepartmentController(DepartmentService departmentService){
		this.departmentService = departmentService;
	}
	
	@RequestMapping(value="/admin/positions",method=RequestMethod.GET)
	public String listPositions(Model model,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("positions",positionIndexService.listAllPositionIndexes() );
		model.addAttribute("departments",departmentService.listAllDepartments() );
		model.addAttribute("fieldSetText","New Position");
		model.addAttribute("savePosition",new PositionIndex() );
		return "positions";
		
	}
	
	@RequestMapping(value = "/admin/positions",params={"selected"},method=RequestMethod.POST)
    public String deletePosition(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
    	model.addAttribute("positions",positionIndexService.listAllPositionIndexes() );
    	model.addAttribute("departments",departmentService.listAllDepartments() );
    	model.addAttribute("savePosition",new PositionIndex() );
        positionIndexService.deletePositionIndex(Integer.parseInt(req.getParameter("selected")));
        return "redirect:positions";
    }
	
	@RequestMapping(value = "/admin/positions",params={"savePosition"},method=RequestMethod.POST)
    public String savePosition(Model model,@ModelAttribute PositionIndex savePosition,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
    	model.addAttribute("positions",positionIndexService.listAllPositionIndexes() );
    	model.addAttribute("departments",departmentService.listAllDepartments() );
    	model.addAttribute("savePosition",new PositionIndex() );
    	positionIndexService.savePositionIndex(savePosition);
        return "redirect:positions";
    }
	
	@RequestMapping(value = "/admin/positions/update",params={"selected"},method=RequestMethod.GET)
	public String updatePositions(Model model,HttpServletRequest req){
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        model.addAttribute("positions",positionIndexService.listAllPositionIndexes() );
    	model.addAttribute("departments",departmentService.listAllDepartments() );
        model.addAttribute("savePosition", positionIndexService.getPositionIndexById(Integer.parseInt(req.getParameter("selected"))));
        model.addAttribute("fieldSetText","Update Page");
        return "positions";
    }

}
