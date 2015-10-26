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
@Table(name="position_index")
public class PositionIndex {
	private int positionId;
	private String positionName;
	private String positionAcronym;
	private String description;
	private int categoryId;
	private Set<Positions> positions = new HashSet<Positions>(0);
	
	public PositionIndex(){
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "POSITION_ID", unique = true,
			nullable = false)
	public int getPositionId(){
		return this.positionId;
	}
	
	public void setPositionId(int positionId){
		this.positionId = positionId;
	}
	
	@Column(name = "POSITION_NAME", nullable = true,
			length = 45)
	public String getPositionName(){
		return this.positionName;
	}
	
	public void setPositionName(String positionName){
		this.positionName = positionName;
	}
	
	@Column(name = "POSITION_ACRONYM", nullable = true,
			length = 10)
	public String getPositionAcronym(){
		return this.positionAcronym;
	}
	
	public void setPositionAcronym(String positionAcronym){
		this.positionAcronym = positionAcronym;
	}
	
	@Column(name = "DESCRIPTION", nullable = true,
			length = 255)
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description= description;
	}

	@Column(name = "CATEGORY_ID", nullable = true)
	public int getCategoryId(){
		return this.categoryId;
	}
	
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	public Set<Positions> getPositions(){
		return this.positions;
	}
	
	public void setPositions(Set<Positions> positions){
		this.positions = positions;
	}
	
}
