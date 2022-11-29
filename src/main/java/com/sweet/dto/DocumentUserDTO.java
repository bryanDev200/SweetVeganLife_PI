package com.sweet.dto;

public class DocumentUserDTO {
	private long id;
	private String description;
	
	public DocumentUserDTO(long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
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
}