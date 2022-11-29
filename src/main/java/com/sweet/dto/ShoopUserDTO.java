package com.sweet.dto;

public class ShoopUserDTO {
	private long shoopId;
	private String shboopAddres;
	
	public ShoopUserDTO(long shoopId, String shboopAddres) {
		super();
		this.shoopId = shoopId;
		this.shboopAddres = shboopAddres;
	}

	public long getShoopId() {
		return shoopId;
	}
	
	public void setShoopId(long shoopId) {
		this.shoopId = shoopId;
	}
	
	public String getShboopAddres() {
		return shboopAddres;
	}
	
	public void setShboopAddres(String shboopAddres) {
		this.shboopAddres = shboopAddres;
	}	
}