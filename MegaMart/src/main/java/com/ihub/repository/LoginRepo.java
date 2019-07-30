package com.ihub.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ihub.model.Login;

public interface LoginRepo extends CrudRepository<Login, String>{

	Optional<Login> findByPassword(String password);

}
