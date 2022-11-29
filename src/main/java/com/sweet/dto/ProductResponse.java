package com.sweet.dto;

import java.util.HashSet;
import java.util.Set;

public class ProductResponse {
	private long id;
	private String description;
	private String productName;
	private double price;
	private int stock;
	private String category;
	private Set<String> images = new HashSet<>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		
		this.category = category;
	}
	
	public Set<String> getImages() {
		return images;
	}
	
	public void setImages(Set<String> images) {
		this.images = images;
	}	
}