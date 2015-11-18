package com.araxsys.domain;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "users")
public class User {
	
	private String username;
	private String password;
	private boolean enabled;
	private String lastName;
	private String firstName;
	private String birthday;
	private String recruiter;
	private byte[] picture;
	private String title;
	private String email;
	private String skype;
	private boolean active;
	private String joinDate;
	private String steam;
	private String tskey;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	public User() {
	}

	@Id
	@Column(name = "USERNAME", unique = true, 
		nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", 
		nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ENABLED", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Column(name = "LAST_NAME", length = 25)	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
		
	@Column(name = "FIRST_NAME", length = 15)	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "BIRTHDAY", nullable = false)
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

		
	@Column(name = "EMAIL", unique = true, length = 255 )	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "SKYPE_USERNAME", length = 32)
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}

		
	@Column(name = "STEAM_USERNAME", length = 32)
	public String getSteam() {
		return steam;
	}
	public void setSteam(String steam) {
		this.steam = steam;
	}

	
	@Column(name = "JOINDATE")
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	@Column(name = "ACTIVE", nullable = false)
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Column(name = "RECRUITER_ID", nullable = false, length = 45)
	public String getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}
	
	@Column(name = "PICTURE")
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	@Column(name = "TITLE", nullable = false, length = 20)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "TS_KEY", nullable = false, length = 64)
	public String getTs() {
		return tskey;
	}
	public void setTs(String tskey) {
		this.tskey = tskey;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	
	


	

}