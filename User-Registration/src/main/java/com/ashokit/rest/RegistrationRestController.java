package com.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindig.User;
import com.ashokit.bo.Cities;
import com.ashokit.bo.Countries;
import com.ashokit.bo.States;
import com.ashokit.service.IUserRegistrationService;

@RestController
public class RegistrationRestController {

	@Autowired
	private IUserRegistrationService regService;

	@PostMapping(value = "/saveUser", consumes = { "application/xml", "application/json" })
	public ResponseEntity<String> saveUser(User user) {
		return null;
	}

	public List<Countries> populateCountries(){
		return null;
	}
		
	public List<States> populateStates(){
		
		return null;
		}
	public List<Cities> populateCities(){
		return null;
	}
}
