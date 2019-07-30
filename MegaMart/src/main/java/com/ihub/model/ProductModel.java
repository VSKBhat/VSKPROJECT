package com.ihub.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihub.repository.ProductRepo;

public class ProductModel {
	@Autowired 
	ProductRepo products;
	private List<Product> productList;

	public ProductModel()
	{
		this.productList=new ArrayList<Product>();
		this.productList.add((Product) products.findAll());
	}
	public List<Product> findAll() {
		return this.productList;
	}
	public Product find(String pid) {
		for (Product product : this.productList) {
			if (product.getPid().equalsIgnoreCase(pid)){
				return product;
			}
		}
		return null;
	}
	
}
