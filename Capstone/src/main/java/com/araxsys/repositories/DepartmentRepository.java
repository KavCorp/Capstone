package com.araxsys.repositories;

import org.springframework.data.repository.CrudRepository;
import com.araxsys.domain.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
