package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.request.UserCredentials;
import com.ashokit.service.IUserRegistrationService;

@RestController
public class UnlockAccountRestController {

	@Autowired
	private IUserRegistrationService regService;

	@PostMapping(value = "/unlockAccount", consumes = { "application/xml", "application/json" })
	public ResponseEntity<String> unlockAccount(@RequestBody UserCredentials credentials) {
		//I have taken UserCredentials as extra entity class to avoid confidential info through url
		String succMsg=null;
		return new ResponseEntity<String>(succMsg, HttpStatus.CREATED);
	}
}
