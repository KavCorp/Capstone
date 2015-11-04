package com.araxsys.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "category")
public class Category {
	private int categoryId;
	private Category parentCategory;
	private String categoryName;
	private String description;
	private boolean visible;
	private Set<Page> page = new HashSet<Page>(0);
	private Set<Category> children = new HashSet<Category>();
	
	public Category(){
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true,
		nullable = false)
	public int getCategoryId(){
		return this.categoryId;
	}
	
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}
	
	@Column(name = "CATEGORY_NAME", nullable = true,
			length = 35)
	public String getCategoryName(){
		return this.categoryName;
	}
	
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}
	
	@Column(name = "DESCRIPTION", nullable = true,
			length = 255)
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	@Column(name = "VISIBLE", nullable = false)
	public boolean getVisible(){
		return this.visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	@OneToMany(mappedBy ="category" ,fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	public Set<Page> getPage(){
		return this.page;
	}
	
	public void setPage(Set<Page> page){
		this.page = page;
	}
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="PARENT_CATEGORY",nullable=true)
	public Category getParentCategory(){
		return this.parentCategory;
	}
	
	public void setParentCategory(Category parentCategory){
		this.parentCategory = parentCategory;
	}
	
	
	@OneToMany(fetch = FetchType.EAGER)
	public Set<Category> getChildren(){
		return this.children;
	}
	
	public void setChildren(Set<Category> children){
		this.children = children;
	}
	


}
