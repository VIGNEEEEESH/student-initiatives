package com.woxsen.studentinitiatives.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Column(name = "email")
	@Id
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Club club;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	
	public User() {}
	public User(String email, String password, Club club) {
		super();
		this.email = email;
		this.password = password;
		this.club = club;
	}
	
}
