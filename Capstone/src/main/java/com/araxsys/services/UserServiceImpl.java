package com.araxsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
