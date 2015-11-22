package com.araxsys.domain;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="rsvp")
public class RSVP  {
	
	protected RSVPCompPK compositePK;
	private Event event;
	private User user;
	private boolean flag;
	private String comment;
	
	public RSVP(){
	}
	
	
	
	@EmbeddedId
	public RSVPCompPK getCompositePK(){
		return this.compositePK;
	}
	
	public void setCompositePK(RSVPCompPK compositePK){
		this.compositePK = compositePK;
	}
		
	@ManyToOne
	@JoinColumn(name = "EVENT", nullable = false)
	public Event getEvent(){
		return this.event;
	}
	
	public void setEvent(Event event){
		this.event = event;
	}
	@ManyToOne
	@JoinColumn(name = "USER", nullable = false)
	public User getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	@Column(name = "FLAG", nullable = false)
	public boolean getFlag(){
		return this.flag;
	}
	
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	@Column(name = "COMMENT", nullable = true)
	public String getComment(){
		return this.comment;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}
	

}
