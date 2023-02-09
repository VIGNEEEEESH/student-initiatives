package com.woxsen.studentinitiatives.dao;

import com.woxsen.studentinitiatives.entities.Club;
import com.woxsen.studentinitiatives.entities.User;

public interface UserDAO {

	public void save(User user);
	public void deleteByEmail(String email);
	public Club loginAndGetClubID(User user);
}
