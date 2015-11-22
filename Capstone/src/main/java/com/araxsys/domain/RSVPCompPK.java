package com.araxsys.domain;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
	public class RSVPCompPK implements Serializable {
		private static final long serialVersionUID = 1L;
		protected String username;
		protected Event eventId;
		
		public RSVPCompPK(){
		}
		 public RSVPCompPK(String username, Event eventId){
			 this.username = username;
			 this.eventId = eventId;
		 }
		@Column(name = "USERNAME", nullable = false)
		 public String getUsername(){
			 return this.username;
		 }
		 
		 public void setUsername(String username){
			 this.username = username;
		 }
		 @ManyToOne(fetch = FetchType.LAZY)
		 @JoinColumn(name = "EVENT_ID", nullable = false)
		 public Event getEventId(){
			 return this.eventId;
		 }
		 
		 public void setEventId(Event eventId){
			 this.eventId = eventId;
		 }
		 
		 @Override
		 @Transient
		 public int hashCode(){
			 final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((username == null) ? 0 : username.hashCode());
			result = prime * result + eventId.getEventId();
			return result;
		 }
		 
		 @Override
		 @Transient
		 public boolean equals(Object obj){
			 if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				RSVPCompPK other = (RSVPCompPK) obj;
				if (username == null) {
					if (other.username != null)
						return false;
				} else if (!username.equals(other.username))
					return false;
				if (eventId != other.eventId)
					return false;
				return true;
		 }
	}