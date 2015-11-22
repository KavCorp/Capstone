package com.araxsys.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="eventtype", catalog ="capstone",
	uniqueConstraints = @UniqueConstraint(
		columnNames = { "type_id", "type_desc" }))
public class EventType {	

	private Integer type_id;
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
	public Integer getTypeId() {
		return this.type_id;
	}
	
	public void setTypeId(Integer type_id){
		this.type_id = type_id;
	}
	
	@Column(name = "TYPE_ID", 
			unique = true, nullable = false)
	public String getTypeDesc() {
		return this.type_desc;
	}
	
	public void setTypeDesc(String desc){
		this.type_desc = desc;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "event")
	public Set<Event> getEvents(){
		return this.events;
	}
	public void setEvents(Set<Event> events){
		this.events = events;
	}
		
	
	


}
