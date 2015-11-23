package com.araxsys.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "eventtype")
public class EventType {	

	private int type_id;
	private String type_desc;
	private Set<Event> events = new HashSet<Event>(0);
	
	public EventType(){
	}
	
	public EventType(String desc){
		this.type_desc = desc;
	}
	public EventType(int typeId, String desc){
		this.type_id = typeId;
		this.type_desc = desc;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TYPE_ID", 
		unique = true, nullable = false)
	public int getType_id() {
		return this.type_id;
	}
	
	public void setType_id(Integer type_id){
		this.type_id = type_id;
	}
	
	@Column(name = "TYPE_DESC", 
			unique = true, nullable = false)
	public String getType_desc() {
		return this.type_desc;
	}
	
	public void setType_desc(String desc){
		this.type_desc = desc;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "eventId")
	public Set<Event> getEvents(){
		return this.events;
	}
	public void setEvents(Set<Event> events){
		this.events = events;
	}
		
	
	


}
