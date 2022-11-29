package com.sweet.dto;

public class ProductListItemDTO {
	private int id;
	private String names;
	private double price;
	private String subCategoria;
	
	public ProductListItemDTO() {}
	
	public ProductListItemDTO(int id, String names, double price, String subCategoria) {
		super();
		this.id = id;
		this.names = names;
		this.price = price;
		this.subCategoria = subCategoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSubCategoria() {
		return subCategoria;
	}
	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}	
}