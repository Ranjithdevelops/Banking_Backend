package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.SignupDetails;
import com.banking.repositories.Signuprepo;

@Service
public class SignupService {
	
	@Autowired
	private Signuprepo signrepo;
	
	public boolean Signup(SignupDetails details) {
		SignupDetails temp=signrepo.save(details);
		if(temp!=null)
			return true;
		return false;
	}

}
