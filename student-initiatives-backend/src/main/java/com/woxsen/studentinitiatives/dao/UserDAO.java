package com.woxsen.studentinitiatives.dao;

import com.woxsen.studentinitiatives.entities.Club;
import com.woxsen.studentinitiatives.entities.User;
import com.woxsen.studentinitiatives.exceptions.InvalidCredentialsException;

public interface UserDAO {

	public void save(User user);
	public void delete(User user) throws InvalidCredentialsException;
	public Club loginAndGetClubID(User user) throws InvalidCredentialsException;
}
