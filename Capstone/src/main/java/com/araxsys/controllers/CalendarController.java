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
import com.araxsys.domain.Event;
import com.araxsys.domain.PositionIndex;
import com.araxsys.domain.RSVP;
import com.araxsys.domain.RSVPCompPK;
import com.araxsys.services.CategoryService;
import com.araxsys.services.DepartmentService;
import com.araxsys.services.EventService;
import com.araxsys.services.EventTypeService;
import com.araxsys.services.RSVPService;
import com.araxsys.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import antlr.debug.MessageAdapter;

@Controller
public class CalendarController {
	private EventTypeService eventTypeService;
	private DepartmentService departmentService;
	private EventService eventService;
	private RSVPService rsvpService;
	private CategoryService categoryService;
	
	private UserService userService;
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
 
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
	public String listEvents(Model model,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("eventTypes", eventTypeService.listAllEventTypes());
		model.addAttribute("departments",departmentService.listAllDepartments());
		model.addAttribute("events", eventService.listAllEvents());
		model.addAttribute("saveEvent",new Event());
		
		return "events";
	}
	@RequestMapping(value = "/admin/events",params={"saveEvent"},method=RequestMethod.POST)
    public String saveEvent(Model model,@ModelAttribute Event saveEvent ,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
    	model.addAttribute("eventTypes", eventTypeService.listAllEventTypes());
    	model.addAttribute("departments",departmentService.listAllDepartments() );
    	model.addAttribute("events", eventService.listAllEvents());
    	model.addAttribute("saveEvent",new Event() );
    	eventService.saveEvent(saveEvent);
        return "redirect:events";
    }	
	@RequestMapping(value="/events",method=RequestMethod.GET)
	public String viewCalendar(Model model,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
    	model.addAttribute("eventTypes", eventTypeService.listAllEventTypes());
    	GsonBuilder builder = new GsonBuilder(); 
    	builder.excludeFieldsWithoutExposeAnnotation();
    	Gson gson = builder.create();
    	model.addAttribute("eventsJson", gson.toJson(eventService.listAllEvents()));
    	model.addAttribute("events",eventService.listAllEvents());
		return "calendar";
	}
	
	@RequestMapping("event/{eventId}")
    public String showProduct(@PathVariable int eventId, Model model,HttpServletRequest req){
		model.addAttribute("rsvps", rsvpService.listAllRSVPsByEvent(eventId));
    	model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
        model.addAttribute("event", eventService.getEventById(eventId));
        model.addAttribute("saveRsvp", new RSVP());
        return "rsvp";
	}
	
	@RequestMapping(value = "/admin/events",params={"selected"},method=RequestMethod.POST)
    public String deleteEvent(Model model,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
    	model.addAttribute("eventTypes", eventTypeService.listAllEventTypes());
    	model.addAttribute("departments",departmentService.listAllDepartments() );
    	model.addAttribute("events", eventService.listAllEvents());
    	model.addAttribute("saveEvent",new Event() );
    	eventService.deleteEvent(eventService.getEventById(Integer.parseInt(req.getParameter("selected"))));
        return "redirect:events";
    }
	@RequestMapping(value = "/admin/events/update",params={"selected"},method=RequestMethod.GET)
    public String updateEvent(Model model ,HttpServletRequest req){
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
    	model.addAttribute("eventTypes", eventTypeService.listAllEventTypes());
    	model.addAttribute("departments",departmentService.listAllDepartments() );
    	model.addAttribute("events", eventService.listAllEvents());
    	model.addAttribute("saveEvent", eventService.getEventById(Integer.parseInt(req.getParameter("selected"))));
        return "events";
    }
	@RequestMapping(value="/events/rsvp",params={"saveRsvp"},method=RequestMethod.POST)
	public String saveRsvp(Model model, HttpServletRequest req, @ModelAttribute RSVP saveRsvp){
		RSVPCompPK pk = saveRsvp.getCompositePK();
		pk.setUsername(req.getUserPrincipal().getName());
		saveRsvp.setCompositePK(pk);
		model.addAttribute("headerCats",req.getSession().getAttribute("headerCats") );
		model.addAttribute("events", eventService.listAllEvents());
		rsvpService.saveRSVP(saveRsvp);
		return "redirect:calendar";
	}
	
	
	
}
