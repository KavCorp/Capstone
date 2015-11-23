package com.araxsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.araxsys.domain.Category;
import com.araxsys.domain.Event;
import com.araxsys.domain.PositionIndex;
import com.araxsys.services.CategoryService;
import com.araxsys.services.DepartmentService;
import com.araxsys.services.EventService;
import com.araxsys.services.EventTypeService;
import com.araxsys.services.RSVPService;

@Controller
public class CalenderController {
	private EventTypeService eventTypeService;
	private DepartmentService departmentService;
	private EventService eventService;
	private RSVPService rsvpService;
	private CategoryService categoryService;
 
	@Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
	@Autowired
	public void setDepartmentService(DepartmentService departmentService){
		this.departmentService = departmentService;
	}
	@Autowired
	public void setEventTypeService(EventTypeService eventTypeService){
		this.eventTypeService = eventTypeService;
	}
	@Autowired
	public void setEventService(EventService eventService){
		this.eventService = eventService;
	}
	@Autowired
	public void setRSVPService(RSVPService rsvpService){
		this.rsvpService = rsvpService;
	}
	
	@RequestMapping(value="/admin/events",method=RequestMethod.GET)
	public String listEvents(Model model){
		model.addAttribute("headerCats",categoryService.listAllCategories());
		model.addAttribute("eventTypes", eventTypeService.listAllEventTypes());
		model.addAttribute("departments",departmentService.listAllDepartments());
		model.addAttribute("events", eventService.listAllEvents());
		model.addAttribute("saveEvent",new Event());
		
		return "events";
	}
	@RequestMapping(value = "/admin/events",params={"saveEvent"},method=RequestMethod.POST)
    public String saveEvent(Model model,@ModelAttribute Event saveEvent){
    	model.addAttribute("headerCats",categoryService.listAllCategories() );
    	model.addAttribute("eventTypes", eventTypeService.listAllEventTypes());
    	model.addAttribute("departments",departmentService.listAllDepartments() );
    	model.addAttribute("events", eventService.listAllEvents());
    	model.addAttribute("saveEvent",new Event() );
    	eventService.saveEvent(saveEvent);
        return "redirect:events";
    }	
}
