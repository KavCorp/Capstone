package com.araxsys.services;

import com.araxsys.domain.User;

public interface UserService {
	Iterable<User>  listAllUsers();

	User saveUser(User User);

	User getUserByName(String username);
	
	User getUserByEmail(String email);
	
	User registerNewUserAccount(User user);

}