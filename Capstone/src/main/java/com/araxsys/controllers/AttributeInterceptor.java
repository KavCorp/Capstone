package com.araxsys.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.araxsys.domain.User;
import com.araxsys.services.CategoryService;
import com.araxsys.services.UserService;
public class AttributeInterceptor extends HandlerInterceptorAdapter {
	
	private CategoryService categoryService;
	@Autowired
    public void setCategoryRepository(CategoryService categoryService) {
        this.categoryService = categoryService;
        
    }
	private UserService userService;
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		System.out.println(request.getSession().getId());
			
		if(request.getSession().getAttribute("headerCats")==null && request.getUserPrincipal()!=null){
			request.getSession().setAttribute("headerCats", categoryService.listAllCategories() );
		}
		if(request.getSession().getAttribute("activeUser")==null && request.getUserPrincipal()!=null){
			request.getSession().setAttribute("activeUser",(User) userService.getUserByName(request.getUserPrincipal().getName()));
		}
		return true;
	}
} 