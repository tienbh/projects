package com.techelevator.tenmo.services;

import java.math.BigDecimal;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.User;

public class AccountService {

	
    private final String BASE_URL; //localhost8080/
    public RestTemplate restTemplate = new RestTemplate();
  
    
    public AccountService(String url) {
        BASE_URL = url;
    }
    
    public BigDecimal getAccountBalance(String token) {
    	BigDecimal bigDecimal = null;
    	bigDecimal = restTemplate.exchange(BASE_URL + "account/balance", HttpMethod.GET,makeAuthEntity(token),BigDecimal.class).getBody();
    	return bigDecimal;
    }
    
    public int getAccountNumber(String token, int userId) {
    	int accountNumber = restTemplate.exchange(BASE_URL + "account/number", HttpMethod.GET, makeAuthEntity(token), int.class).getBody();
    	return accountNumber;
    }
    

  
    //makeAuthEntity with the token passed in to make sure the user is logged in and it is the correct user
    private HttpEntity makeAuthEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }


}
