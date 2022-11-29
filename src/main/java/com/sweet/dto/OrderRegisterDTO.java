package com.sweet.dto;
	
	import java.util.ArrayList;
	import java.util.List;

public class OrderRegisterDTO {
	private double finalAmount;
	private long paymentId;
	private long shoopId;
	private long userId;
	private List<OrderDetailDTO> details = new ArrayList<>();
	
	public double getFinalAmount() {
		return finalAmount;
	}
	
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	
	public long getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	
	public long getShoopId() {
		return shoopId;
	}
	
	public void setShoopId(long shoopId) {
		this.shoopId = shoopId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public List<OrderDetailDTO> getDetails() {
		return details;
	}
	
	public void setDetails(List<OrderDetailDTO> details) {
		this.details = details;
	}	
}