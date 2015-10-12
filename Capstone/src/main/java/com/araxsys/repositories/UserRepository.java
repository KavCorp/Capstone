package com.araxsys.repositories;

import org.springframework.data.repository.CrudRepository;
import com.araxsys.domain.User;

public interface UserRepository extends CrudRepository<User, String>{
	
}