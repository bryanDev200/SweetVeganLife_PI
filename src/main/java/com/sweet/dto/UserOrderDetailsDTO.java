package com.sweet.dto;

public class UserOrderDetailsDTO {
	private long productId;
	private String productName;
	private double productPrice;
	private int productQuantity;
	
	public UserOrderDetailsDTO() {}
	
	public UserOrderDetailsDTO(long productId, String productName, double productPrice,
			int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}	
}