package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.banking.model.JwtResponse;

public class JwtService {
	
	@Autowired
	private WebClient webclient;
	
	public JwtResponse getJwt() {
		return webclient.post().uri("/jwttoken").bodyValue(null, null).retrieve().bodyToMono(JwtResponse.class).block();
	}

}
