package com.araxsys.boostrap;

import com.araxsys.domain.User;
import com.araxsys.repositories.UserRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    private Logger log = Logger.getLogger(UserLoader.class);

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        User user = new User();
        user.setPassword("user");
       
        user.setUsername("user");
        userRepository.save(user);


        log.info("Saved user: " + user.getUsername());

        User admin = new User();
        admin.setPassword("admin");
        admin.setUsername("admin");
        userRepository.save(admin);
        log.info("Saved admin:" + admin.getUsername());
    }
}
