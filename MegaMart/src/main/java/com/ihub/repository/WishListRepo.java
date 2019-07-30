package com.ihub.repository;

import org.springframework.data.repository.CrudRepository;

import com.ihub.model.WishList;

public interface WishListRepo extends CrudRepository<WishList, String> {

	void save(String pid);

}
