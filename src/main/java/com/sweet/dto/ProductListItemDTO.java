package com.sweet.dto;

import java.util.HashSet;
import java.util.Set;

import com.sweet.entity.ProductImage;

public class ProductListItemDTO {
	private int productId;
	private String description;
	private String name;
	private double price;
	private Set<ProductImage> images = new HashSet<>();
	private int stock;
	private String category;
	
	public ProductListItemDTO() {}
	
	public ProductListItemDTO(int id, String names, double price, String subCategoria, String description, int stock, Set<ProductImage> images) {
		super();
		this.productId = id;
		this.name = names;
		this.price = price;
		this.category = subCategoria;
		this.description = description;
		this.stock = stock;
		this.images = images;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<ProductImage> getImages() {
		return images;
	}

	public void setImages(Set<ProductImage> images) {
		this.images = images;
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
}