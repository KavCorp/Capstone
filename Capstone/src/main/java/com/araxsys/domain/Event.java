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
@Table(name = "event")
public class Event {
	private int eventId;
	private String name;
	private EventType type;
	private Department department;
	private String description;
	private boolean rsvp;
	private String starttime;
	private String endtime;
	private Set<RSVP> rsvps = new HashSet<RSVP>(0);
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
	
	
	@Column(name = "DESCRIPTION", nullable = true,
			length = 35)
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	@Column(name = "RSVP", nullable = true)
	public boolean getRsvp(){
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
	@OneToMany(mappedBy="compositePK.eventId")
	public Set<RSVP> getRSVPs(){
		return rsvps;
	}
	
	public void setRSVPs(Set<RSVP> rsvps){
		this.rsvps = rsvps;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID", nullable = false)
	public EventType getType(){
		return this.type;
	}
	public void setType(EventType type){
		this.type = type;
	}
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	public Department getDepartment(){
		return this.department;
	}
	public void setDepartment(Department department){
		this.department = department;
	}
}
