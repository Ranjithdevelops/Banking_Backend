package com.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.model.LoginDetails;

@Repository
public interface Loginrepo extends JpaRepository<LoginDetails,Long>{
	List<LoginDetails> findByName(String name);

}
