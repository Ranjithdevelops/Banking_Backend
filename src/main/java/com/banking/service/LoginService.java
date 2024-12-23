package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.LoginDetails;
import com.banking.repositories.Loginrepo;

@Service
public class LoginService {
	@Autowired
	private Loginrepo loginrepository;
	public boolean loginverification(LoginDetails login) {
		List<LoginDetails> result=loginrepository.findByName(login.getName());
		boolean response=result.stream().anyMatch(e->e.getName().equals(login.getName())&& e.getPassword().equals(login.getPassword()));
		return response;
	}
}
