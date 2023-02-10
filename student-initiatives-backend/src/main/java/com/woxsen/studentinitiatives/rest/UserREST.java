package com.woxsen.studentinitiatives.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woxsen.studentinitiatives.entities.Club;
import com.woxsen.studentinitiatives.entities.User;
import com.woxsen.studentinitiatives.exceptions.InvalidCredentialsException;
import com.woxsen.studentinitiatives.service.UserService;

@RestController
@RequestMapping("/api")
public class UserREST {
	private UserService userService;
	
	
	public UserREST(@Autowired UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(value = "/user/")
	public void saveUser(@RequestBody User user) {
		System.out.println("Executed");
		userService.save(user);
	}
	
	@DeleteMapping("/user/{email}")
	public void deleteUser(@PathVariable String email) {
		userService.deleteByEmail(email);
	}
	
	@GetMapping("/user/{email}/{password}")
	public Object login(@PathVariable String email, @PathVariable String password) {
		System.out.println("=>>>>>>>>>>>>>>>>>> email = "+email+ " and password = "+password);
		User user = new User(email, password, null);
		try {
		Club club = userService.loginAndGetClubID(user);
		System.out.println(club.getClubName());
		return club;
		}
		catch(InvalidCredentialsException e)
		{
			return new ResponseEntity<String>("The combination was not found",HttpStatus.NOT_FOUND);
		}
	}
}
