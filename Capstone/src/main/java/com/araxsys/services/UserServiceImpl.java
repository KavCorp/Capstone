package com.araxsys.services;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araxsys.domain.Category;
import com.araxsys.domain.User;
import com.araxsys.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    @Override
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByName(String username) {
        return userRepository.findOne(username);
    }

    @Override
    public User saveUser(User User) {
        return userRepository.save(User);
    }
    
    
    public User registerNewUserAccount(User user) {
        if (emailExist(user.getEmail())) {   
            return null;
        }
          
        return userRepository.save(user);       
    }   
    private boolean emailExist(String email) {
        User user = getUserByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
    
    public User getUserByEmail(String email){
		Iterable<User> users = userRepository.findAll();
		User match = null;
		boolean flag = false;
		for(User user: users){
			if(user.getEmail().equals(email)){
				flag = true;
				match = user;
				break;
			}
		}
		if(flag){
			return match;
		}else{
			System.out.println("No matches found for email: "+email);
			return match;
			
		}
	}
}
