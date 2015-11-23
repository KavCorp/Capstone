package com.araxsys.boostrap;

import com.araxsys.domain.Category;
import com.araxsys.domain.EventType;
import com.araxsys.domain.Page;
import com.araxsys.domain.User;

import com.araxsys.repositories.UserRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.araxsys.repositories.CategoryRepository;
import com.araxsys.repositories.EventTypeRepository;
import com.araxsys.repositories.PageRepository;



@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private PageRepository pageRepository;
    private CategoryRepository categoryRepository;
    private EventTypeRepository eventTypeRepository;

    private Logger log = Logger.getLogger(UserLoader.class);

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Autowired
    public void setPageRepository(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }
    
    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Autowired
    public void setEventTypeRepository(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	
        User user = new User();
        user.setPassword("user");
       
        user.setUsername("user");
        //userRepository.save(user);


        log.info("Saved user: " + user.getUsername());

        User admin = new User();
        admin.setPassword("admin");
        admin.setUsername("admin");
        admin.setActive(true);
        admin.setEnabled(true);
        
        EventType type = new EventType();
        type.setType_desc("testtstetst");
        eventTypeRepository.save(type);
        
        //userRepository.save(admin);
        log.info("Saved admin:" + admin.getUsername());
        
    
        
        
    }
}
