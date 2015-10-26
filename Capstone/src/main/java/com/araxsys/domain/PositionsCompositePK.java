package com.araxsys.domain;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
	public class PositionsCompositePK implements Serializable {
		private static final long serialVersionUID = 1L;
		protected String username;
		protected int categoryId;
		
		public PositionsCompositePK(){
		}
		 public PositionsCompositePK(String username, int categoryId){
			 this.username = username;
			 this.categoryId = categoryId;
		 }
		 
		 @Column(name = "USERNAME", nullable = false)
		 public String getUsername(){
			 return this.username;
		 }
		 
		 public void setUsername(String username){
			 this.username = username;
		 }
		 
		 @Column(name = "CATEGORY_ID", nullable = false)
		 public int getCategoryId(){
			 return this.categoryId;
		 }
		 
		 public void setCategoryId(int categoryId){
			 this.categoryId = categoryId;
		 }
		 
		 @Override
		 @Transient
		 public int hashCode(){
			 final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((username == null) ? 0 : username.hashCode());
			result = prime * result + categoryId;
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
				if (categoryId != other.categoryId)
					return false;
				return true;
		 }
	}