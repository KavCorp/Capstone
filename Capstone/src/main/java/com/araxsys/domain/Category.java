package com.araxsys.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	private int categoryId;
	private int parentCategory;
	private String categoryName;
	private String description;
	private boolean visible;
	private Set<Category> children = new HashSet<Category>(0);
	private Set<Page> page = new HashSet<Page>(0);
	
	public Category(){
	}
	
	@Id
	@Column(name = "CATEGORY_ID", unique = true,
		nullable = false)
	public int getCategoryId(){
		return this.categoryId;
	}
	
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}
	
	@Column(name = "PARENT_CATEGORY", unique = false,
			nullable = true)	
	public int getParentCategory(){
		return this.parentCategory;
	}
	
	public void setParentCategory(int parentCategory){
		this.parentCategory = parentCategory;
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
	public boolean getVisbible(){
		return this.visible;
	}
	
	public void setVisibile(boolean visible){
		this.visible = visible;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Page> getPage(){
		return this.page;
	}
	
	public void setPage(Set<Page> page){
		this.page = page;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Category parent;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Category> getParent(){
		return this.children;
	}
	
	public void setParent(Set<Category> children){
		this.children = children;
	}

}
