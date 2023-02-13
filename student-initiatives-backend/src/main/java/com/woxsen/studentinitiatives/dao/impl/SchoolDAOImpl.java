package com.woxsen.studentinitiatives.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woxsen.studentinitiatives.dao.SchoolDAO;
import com.woxsen.studentinitiatives.entities.Club;
import com.woxsen.studentinitiatives.entities.School;

import jakarta.persistence.EntityManager;

@Repository
public class SchoolDAOImpl implements SchoolDAO {

	private EntityManager entityManager;
	
	@Autowired
	public SchoolDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public void add(School school) {
		Session session = entityManager.unwrap(Session.class);
		
		session.persist(school);
	}

	@Override
	public void removeById(int schoolId) {
		Session session = entityManager.unwrap(Session.class);
		
		School school = session.get(School.class, schoolId);
		
		session.remove(school);
	}

	@Override
	public List<Club> getClubListBySchoolId(int schoolId) {
		Session session = entityManager.unwrap(Session.class);
		School school = session.get(School.class, schoolId);
		return school.getClubs();
	}


	@Override
	public School getById(int schoolId) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(School.class, schoolId);
	}


	@Override
	public List<School> getSchools() {
		Session session = entityManager.unwrap(Session.class);
		
		List<School> schools = session.createSelectionQuery("from School",School.class).getResultList();
		return schools;
	}

}
