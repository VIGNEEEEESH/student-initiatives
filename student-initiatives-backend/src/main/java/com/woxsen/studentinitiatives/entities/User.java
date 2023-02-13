package com.woxsen.studentinitiatives.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
	
	@Column(name = "email")
	@Id
	@Pattern(regexp = "/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/\n")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@JsonManagedReference(value = "email")
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
