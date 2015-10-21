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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	private int categoryId;
	private int parentCategory;
	private String categoryName;
	private String description;
	private boolean visible;
	private Set<Page> page = new HashSet<Page>(0);
	
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
	public boolean getVisible(){
		return this.visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	@OneToMany(mappedBy ="category" ,fetch = FetchType.LAZY)
	public Set<Page> getPage(){
		return this.page;
	}
	
	public void setPage(Set<Page> page){
		this.page = page;
	}
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="parentCategory")
	private Category parent;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Category> children = new HashSet<Category>();
	


}
