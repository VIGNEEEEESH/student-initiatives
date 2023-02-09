package com.woxsen.studentinitiatives.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.woxsen.studentinitiatives.dao.UserDAO;
import com.woxsen.studentinitiatives.entities.Club;
import com.woxsen.studentinitiatives.entities.User;

import jakarta.persistence.EntityManager;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public void save(User user) {
		Session session = entityManager.unwrap(Session.class);
		
		session.persist(user);

	}

	@Override
	public void deleteByEmail(String email) {
		Session session = entityManager.unwrap(Session.class);
		
		session.remove(email);
	}

	@Override
	public Club loginAndGetClubID(User user) {
		
		Session session = entityManager.unwrap(Session.class);
		
		User 
		
		return null;
	}

}
