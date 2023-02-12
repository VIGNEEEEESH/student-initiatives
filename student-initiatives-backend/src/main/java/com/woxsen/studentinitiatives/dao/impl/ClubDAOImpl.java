package com.woxsen.studentinitiatives.dao.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.woxsen.studentinitiatives.dao.ClubDAO;
import com.woxsen.studentinitiatives.entities.Club;
import com.woxsen.studentinitiatives.exceptions.NoSuchFileFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

@Repository
public class ClubDAOImpl implements ClubDAO {

	private EntityManager entityManager;
	
	
	@Autowired
	public ClubDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Club findById(int clubId) {
		Session session = entityManager.unwrap(Session.class);
		
		Club club = session.get(Club.class, clubId);
		
		return club;
	}

	@Override
	public List<Club> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Club> clubs = session.createSelectionQuery("from Club",Club.class).getResultList();
		return clubs;
	}

	@Override
	public InputStreamResource getImage(int clubId, String type) throws NoSuchFileFoundException {		
		var imgFile = new ClassPathResource("images/"+type+"/"+clubId+".jpeg");
		
		try {
			return new InputStreamResource(imgFile.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			throw new NoSuchFileFoundException(imgFile + " doesn't exist!");
		}
		
		
	}

	@Override
	public void saveImage(int clubId, String type, MultipartFile file) {
//		File newImage = new File("images/"+type+"/"+clubId+".jpeg");
//		
//		try {
//			file.transferTo(newImage);
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//		}
		String filePath = "images/"+type;
		File f = new File(filePath);
		if(!f.exists()) f.mkdir();
		try {
			Files.copy(file.getInputStream(), Paths.get(filePath + "/" + clubId + ".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int clubId) {
		Session session = entityManager.unwrap(Session.class);
		Club club = session.get(Club.class, clubId);
		if(club == null) throw new EntityNotFoundException();
		session.remove(club);
	}
	
}
