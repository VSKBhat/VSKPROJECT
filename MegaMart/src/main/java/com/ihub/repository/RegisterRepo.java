package com.ihub.repository;

import org.springframework.data.repository.CrudRepository;

import com.ihub.model.Register;

public interface RegisterRepo extends CrudRepository<Register, String> {

}
