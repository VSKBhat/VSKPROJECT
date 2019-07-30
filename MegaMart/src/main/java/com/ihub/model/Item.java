package com.ihub.model;

import java.util.Optional;

public class Item {
	private Product product;
	private int quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item(Product product2, int quantity) {
		
		this.product = product2;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + "]";
	}
	
	
	
}
