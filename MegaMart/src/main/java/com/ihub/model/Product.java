package com.ihub.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_tb")
public class Product {
	@Id
	public String pid;
	public String pname;
	public String description;
	private  double price;
	public double discount;
	public double delivery_charge;
	public int avg_rating;
	public String seller_name;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getDelivery_charge() {
		return delivery_charge;
	}
	public void setDelivery_charge(double delivery_charge) {
		this.delivery_charge = delivery_charge;
	}
	public int getAvg_rating() {
		return avg_rating;
	}
	public void setAvg_rating(int avg_rating) {
		this.avg_rating = avg_rating;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", description=" + description + ", price=" + price
				+ ", discount=" + discount + ", delivery_charge=" + delivery_charge + ", avg_rating=" + avg_rating
				+ ", seller_name=" + seller_name + "]";
	}
	
	
	

}
