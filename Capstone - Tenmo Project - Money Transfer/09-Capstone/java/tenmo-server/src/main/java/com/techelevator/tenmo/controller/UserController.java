package com.techelevator.tenmo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.dao.UserSqlDAO;
import com.techelevator.tenmo.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserDAO dao;
	
	public UserController(UserDAO userDAO) {
		
        this.dao = userDAO;
    }
	 //getting all of the users info
	//localhost8080/users
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<User> listUsers(){
		return dao.findAll();
	}
	
	
}
