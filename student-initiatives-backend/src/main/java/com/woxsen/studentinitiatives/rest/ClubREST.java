package com.woxsen.studentinitiatives.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woxsen.studentinitiatives.entities.Club;
import com.woxsen.studentinitiatives.exceptions.NoSuchFileFoundException;
import com.woxsen.studentinitiatives.service.ClubService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class ClubREST {
	
	private ClubService clubService;
	
	@Autowired
	public ClubREST(ClubService clubService) {
		this.clubService = clubService;
	}
	
	@CrossOrigin
	@GetMapping(value = "/club/{clubId}")
	public Club getClubById(@PathVariable int clubId) {
		return clubService.findById(clubId);
	}
	
	@CrossOrigin
	@GetMapping(value = "/club/")
	public List<Club> getClubs(){
		return clubService.findAll();
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/club/{clubId}")
	public ResponseEntity<String> deleteClub(@PathVariable int clubId){
		try {
		clubService.deleteById(clubId);
		return ResponseEntity.ok("Club deleted successfully");
		} 
		catch(EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No club was found for the provided club ID");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}
	
	@CrossOrigin
	@GetMapping(value = "/club/{clubId}/image/{type}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<InputStreamResource> getImage(@PathVariable int clubId,@PathVariable String type) throws NoSuchFileFoundException{
		return ResponseEntity
				.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(clubService.getImage(clubId, type));
	}
	
	@CrossOrigin
	@PutMapping(value = "/club/{clubId}/image/{type}")
	public ResponseEntity<String> saveImage(@RequestParam("image") MultipartFile file, @PathVariable int clubId, @PathVariable String type){
		clubService.saveImage(clubId, type, file);
		return ResponseEntity.ok().body("Image saved successfully");
	}
}
