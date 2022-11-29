package com.sweet.dto;

public class ProductRegisterDTO {
	private String description;
	private String name;
	private double price;
	private int stock;
	private int subcategoryId;
	private int supplierId;
	private boolean enabled;
	
	public ProductRegisterDTO() {}
	
	public ProductRegisterDTO(String description, String name, double price, int stock, int subcategoryId,
			int supplierId, boolean enabled) {
		super();
		this.description = description;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.subcategoryId = subcategoryId;
		this.supplierId = supplierId;
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}	
}