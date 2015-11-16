package com.araxsys.domain;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
	public class PositionsCompositePK implements Serializable {
		private static final long serialVersionUID = 1L;
		protected String username;
		protected int departmentId;
		
		public PositionsCompositePK(){
		}
		 public PositionsCompositePK(String username, int departmentId){
			 this.username = username;
			 this.departmentId = departmentId;
		 }
		 
		 @Column(name = "USERNAME", nullable = false)
		 public String getUsername(){
			 return this.username;
		 }
		 
		 public void setUsername(String username){
			 this.username = username;
		 }
		 
		 @Column(name = "CATEGORY_ID", nullable = false)
		 public int getDepartmentId(){
			 return this.departmentId;
		 }
		 
		 public void setDepartmentId(int departmentId){
			 this.departmentId = departmentId;
		 }
		 
		 @Override
		 @Transient
		 public int hashCode(){
			 final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((username == null) ? 0 : username.hashCode());
			result = prime * result + departmentId;
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
				PositionsCompositePK other = (PositionsCompositePK) obj;
				if (username == null) {
					if (other.username != null)
						return false;
				} else if (!username.equals(other.username))
					return false;
				if (departmentId != other.departmentId)
					return false;
				return true;
		 }
	}