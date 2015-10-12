package com.araxsys.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "page")
public class Page {
	
	private int pageId;
	private int categoryId;
	private String content;
	private boolean visible;
	
	public Page(){
	}
	
	@Id
	@Column(name = "PAGE_ID", unique = true,
			nullable = false)
	public int getPageId(){
		return this.pageId;
	}
	
	public void setPageId(int pageId){
		this.pageId = pageId;
	}
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public int getCategoryId(){
		return this.categoryId;
	}
	
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
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
