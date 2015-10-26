package com.araxsys.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.araxsys.domain.Department;
import com.araxsys.repositories.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentRepository departmentRepository;
	
	@Autowired
	public void setDepartmentRepository(DepartmentRepository departmentRepository){
		this.departmentRepository = departmentRepository;
	}
	
	@Override
	public Iterable<Department> listAllDepartments(){
		return departmentRepository.findAll();
	}
	
	@Override
	public Department getDepartmentById(int departmentId){
		return departmentRepository.findOne(departmentId);
	}
	
	@Override
	public Department saveDepartment(Department department){
		return departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(int departmentId){
		
		departmentRepository.delete(departmentId);
	}
	
	@Override
	public Department getDepartmentByName(String departmentName){
		Iterable<Department> departments = departmentRepository.findAll();
		Department match = null;
		boolean flag = false;
		for(Department department: departments){
			if(department.getDepartmentName().equals(departmentName)){
				flag = true;
				match = department;
				break;
			}
		}
		if(flag){
			return match;
		}else{
			System.out.println("No matches found for department name: "+departmentName);
			return match;
			
		}
	}
}
