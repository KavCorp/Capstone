package com.araxsys.domain;


import static javax.persistence.GenerationType.IDENTITY;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="positions")
public class Positions  {
	
	protected PositionsCompositePK compositePK;
	private PositionIndex positionIndex;
	private boolean primaryPositionFlag;
	
	public Positions(){
	}
	
	
	
	@EmbeddedId
	public PositionsCompositePK getCompositePK(){
		return this.compositePK;
	}
	
	public void setCompositePK(PositionsCompositePK compositePK){
		this.compositePK = compositePK;
	}
	
	@ManyToOne
	@JoinColumn(name = "POSITION_INDEX", nullable = false)
	public PositionIndex getPositionIndex(){
		return this.positionIndex;
	}
	
	public void setPositionIndex(PositionIndex positionIndex){
		this.positionIndex = positionIndex;
	}
	
	@Column(name = "PRIMARY_POSITION_FLAG", nullable = true)
	public boolean getPrimaryPositionFlag(){
		return this.primaryPositionFlag;
	}
	
	public void setPrimaryPositionFlag(boolean primaryPositionFlag){
		this.primaryPositionFlag = primaryPositionFlag;
	}
	

}
