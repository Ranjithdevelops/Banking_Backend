package com.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.model.SignupDetails;

@Repository
public interface Signuprepo extends JpaRepository<SignupDetails, Long> {
	

}
