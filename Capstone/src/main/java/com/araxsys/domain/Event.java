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
@Table(name = "event")
public class Event {
	private int eventId;
	private String name;
	private int type_id;
	private int department_id;
	private String description;
	private boolean rsvp;
	private String starttime;
	private String endtime;
	private boolean visible;
	private Set<Page> page = new HashSet<Page>(0);
	
	public Event(){
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EVENT_ID", unique = true,
		nullable = false)
	public int getEventId(){
		return this.eventId;
	}
	
	public void setEventId(int eventId){
		this.eventId = eventId;
	}
	@Column(name = "NAME", nullable = true,
			length = 35)
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	@Column(name = "TYPE_ID", nullable = true)
	public int getType_id(){
		return this.type_id;
	}
	public void setType_id(int type_id){
		this.type_id = type_id;
	}
	
	@Column(name = "DEPARTMENT_ID", nullable = false)
	public int getDepartment_id(){
		return this.department_id;
	}
	public void setDepartment_id(int department_id){
		this.department_id = department_id;
	}
	
	@Column(name = "DESCRIPTION", nullable = true,
			length = 35)
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	@Column(name = "RSVP", nullable = true)
	public boolean getRSVP(){
		return this.rsvp;
	}
	public void setRsvp(boolean rsvp){
		this.rsvp = rsvp;
	}
	
	@Column(name = "START_TIME", nullable = true)
	public String getStarttime(){
		return this.starttime;
	}
	public void setStarttime(String starttime){
		this.starttime = starttime;
	}
	@Column(name = "END_TIME", nullable = true)
	public String getEndtime(){
		return this.endtime;
	}
	public void setEndtime(String endtime){
		this.endtime = endtime;
	}
}
