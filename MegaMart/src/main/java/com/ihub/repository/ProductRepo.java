package com.ihub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ihub.model.Product;

public interface ProductRepo extends CrudRepository<Product, String> {

	List<Product> findProductByPname(String keyword);

}
