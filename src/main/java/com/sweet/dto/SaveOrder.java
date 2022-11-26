package com.sweet.dto;

	import java.util.List;

public class SaveOrder {
	private int orderNumber;
	private int finalAmount;
	private long shoopId;
	private long userId;
	private long paymentId;
	private List<SaveOrderDetail> details;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public int getFinalAmount() {
		return finalAmount;
	}
	
	public void setFinalAmount(int finalAmount) {
		this.finalAmount = finalAmount;
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
	
	public long getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	
	public List<SaveOrderDetail> getDetails() {
		return details;
	}
	
	public void setDetails(List<SaveOrderDetail> details) {
		this.details = details;
	}	
}