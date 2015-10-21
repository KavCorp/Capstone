package com.araxsys.domain;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "page")
public class Page {
	
	private int pageId;
	private Category category;
	private String content;
	private boolean visible;
	private String pageName;
	
	public Page(){
	
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PAGE_ID", unique = true,
			nullable = false)
	
	public int getPageId(){
		return this.pageId;
	}
	
	public void setPageId(int pageId){
		this.pageId = pageId;
	}
	
	@Column(name="PAGE_NAME", nullable=true)
	public String getPageName(){
		return this.pageName;
	}
	
	public void setPageName(String pageName){
		this.pageName = pageName;
	}
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public Category getCategory(){
		return this.category;
	}
	
	public void setCategory(Category category){
		this.category = category;
	}
	
	@Column(name = "CONTENT", nullable = true,
			length = 60000)
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	@Column(name = "VISIBLE", nullable = false)
	public boolean getVisible(){
		return this.visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
}
