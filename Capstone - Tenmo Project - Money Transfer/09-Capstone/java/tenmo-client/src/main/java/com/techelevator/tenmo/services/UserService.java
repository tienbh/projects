package com.techelevator.tenmo.services;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import com.techelevator.tenmo.models.User;

public class UserService {
	
	
    private final String BASE_URL; //localhost:8080/
    public RestTemplate restTemplate = new RestTemplate();
    //private final ConsoleService console = new ConsoleService();
    
    public UserService(String url) {
        BASE_URL = url;
    }
 
    //getting all of the users info
    //localhost8080/users
    public User[] getAll(String token) {
    	User[] user = null;
    	user = restTemplate.exchange(BASE_URL + "users",HttpMethod.GET,makeAuthEntity(token),User[].class).getBody();
    	return user;
    }
    
 
    private HttpEntity makeAuthEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }
   
}