package com.banking.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;


import com.banking.model.SignupDetails;
import com.banking.repositories.Signuprepo;



@Service
public class SignupService {
	
	@Autowired
	private Signuprepo signrepo;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaObject;
	
	public boolean Signup(SignupDetails details) {
		SignupDetails returnData=signrepo.save(details);
		if(returnData!=null)
			return true;
		return false;
	}
	
	public void emailMessageProducer(String email) {
		CompletableFuture<SendResult<String, String>> producerResult=kafkaObject.send("email-verification-code-topic", "email", email);
		producerResult.thenAccept(result->{System.out.println(result.getRecordMetadata().partition()+", topic: "+result.getRecordMetadata().topic());}).exceptionally(result->{System.err.println("Error sending message to kafka");return null;});
	}

}
