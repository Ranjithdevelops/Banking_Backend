package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.banking.model.ResponseEntityObject;
import com.banking.model.SignupDetails;
import com.banking.service.SignupService;

@RestController
public class SignupController {

	@Autowired
	private SignupService signupservice;
	
	@PostMapping("/Signup")
	public ResponseEntity<ResponseEntityObject> SignupValidation(@RequestBody SignupDetails Signup) {
		boolean response=signupservice.Signup(Signup);
		signupservice.emailMessageProducer(Signup.getEmail());
		if(response) {
			ResponseEntityObject responseObject=new ResponseEntityObject("Signup successful!!!","dasdasdhiasdaui");
			return new ResponseEntity<ResponseEntityObject>(responseObject, HttpStatus.OK);
		}
		else {
			ResponseEntityObject responseObject=new ResponseEntityObject("Signup unsuccessful",null);
			return new ResponseEntity<ResponseEntityObject>(responseObject, HttpStatus.UNAUTHORIZED);
		}
		
	}
}
