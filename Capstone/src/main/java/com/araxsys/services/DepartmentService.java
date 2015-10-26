package com.araxsys.services;

import com.araxsys.domain.Department;

public interface DepartmentService {
	Iterable<Department> listAllDepartments();
	
	Department saveDepartment(Department department);
	
	void deleteDepartment(int departmentId);
	
	Department getDepartmentById(int departmentId);
	
	Department getDepartmentByName(String departmentName);

}
