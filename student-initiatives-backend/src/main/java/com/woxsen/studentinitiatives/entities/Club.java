package com.woxsen.studentinitiatives.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clubs")
public class Club {
	
	
	@Column(name = "club_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clubId;
	
	@Column(name = "club_name")
	private String clubName;
	
	@Column(name = "president_name")
	private String presidentEmail;
	
	@Column(name = "president_name")
	private String presidentName;
	
	@Column(name = "vice_president_name")
	private String vicePresidentName;

	public Club(String clubName, String presidentEmail, String presidentName, String vicePresidentName) {
		this.clubName = clubName;
		this.presidentEmail = presidentEmail;
		this.presidentName = presidentName;
		this.vicePresidentName = vicePresidentName;
	}
	
	public Club() {}
	
	
}
