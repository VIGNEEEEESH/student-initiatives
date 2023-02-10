package com.woxsen.studentinitiatives.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "president_email")
	private User user;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "school_id")
	private School school;
	
	@Column(name = "president_name")
	private String presidentName;
	
	@Column(name = "vice_president_name")
	private String vicePresidentName;

	public Club(String clubName, String presidentName, String vicePresidentName, User user, School school) {
		this.clubName = clubName;
		this.user = user;
		this.school = school;
		this.presidentName = presidentName;
		this.vicePresidentName = vicePresidentName;
	}
	
	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}


	public String getPresidentName() {
		return presidentName;
	}

	public void setPresidentName(String presidentName) {
		this.presidentName = presidentName;
	}

	public School getschool() {
		return school;
	}

	public void setschool(School school) {
		this.school = school;
	}

	public String getVicePresidentName() {
		return vicePresidentName;
	}

	public void setVicePresidentName(String vicePresidentName) {
		this.vicePresidentName = vicePresidentName;
	}

	public Club() {}

	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubName=" + clubName + ", user=" + user + ", school=" + school
				+ ", presidentName=" + presidentName + ", vicePresidentName=" + vicePresidentName + "]";
	}
	
	
}
