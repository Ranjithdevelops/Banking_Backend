package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.LoginDetails;
import com.banking.model.ResponseEntityObject;
import com.banking.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/Login")
	public ResponseEntity<ResponseEntityObject> LoginValidation(@RequestBody LoginDetails login) {
		boolean response=loginService.loginverification(login);
		if(response) {
			ResponseEntityObject responseObject=new ResponseEntityObject("login successful!!!","dasdasdhiasdaui");
			return new ResponseEntity<ResponseEntityObject>(responseObject, HttpStatus.OK);
		}
		else {
			ResponseEntityObject responseObject=new ResponseEntityObject("login unsuccessful",null);
			return new ResponseEntity<ResponseEntityObject>(responseObject, HttpStatus.UNAUTHORIZED);
		}
		
	}
}
