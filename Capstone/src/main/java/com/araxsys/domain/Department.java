package com.araxsys.domain;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "department")
public class Department {
	private int departmentId;
	private String departmentName;
	private String departmentHead;
	private String description;
	private Department parentDepartmentId;
	
	public Department(){
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DEPARTMENT_ID", unique = true,
			nullable = false)
	public int getDepartmentId(){
		return this.departmentId;
	}
	
	public void setDepartmentId(int departmentId){
		this.departmentId = departmentId;
	}
	
	@Column(name = "DEPARTMENT_NAME", nullable = true,
			length = 35)
	public String getDepartmentName(){
		return this.departmentName;
	}
	
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	
	@Column(name = "DEPARTMENT_HEAD", nullable = true,
			length = 45)
	public String getDepartmentHead(){
		return this.departmentHead;
	}
	
	public void setDepartmentHead(String departmentHead){
		this.departmentHead = departmentHead;
	}
	
	@Column(name = "DESCRIPTION", nullable = true,
			length = 255)
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	@ManyToOne
	@JoinColumn(name = "PARENT_DEPARTMENT_ID", nullable = true)
	public Department getParentDepartmentId(){
		return this.parentDepartmentId;
	}
	
	public void setParentDepartmentId(Department parent){
		this.parentDepartmentId= parent;
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="department")
	private Set<Department> children = new HashSet<Department>();
	
	@OneToMany(mappedBy="positionIndex")
	private Set<PositionIndex> positionIndexes = new HashSet<PositionIndex>(0);

}
