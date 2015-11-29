package com.araxsys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.araxsys.controllers.AttributeInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public AttributeInterceptor attributeInterceptor(){
		return new AttributeInterceptor();
		
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(attributeInterceptor());
	    
	} 
	
}
