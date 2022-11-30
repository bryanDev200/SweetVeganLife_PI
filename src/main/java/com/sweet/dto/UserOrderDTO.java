package com.sweet.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserOrderDTO {
	private long id;
	private Date orderDate;
	private double finalAmount;
	private String paymentName;
	private List<UserOrderDetailsDTO> details = new ArrayList<UserOrderDetailsDTO>();
	
	public UserOrderDTO() {}
	
	public UserOrderDTO(long id, Date orderDate, double finalAmount, String paymentName,
			List<UserOrderDetailsDTO> details) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.finalAmount = finalAmount;
		this.paymentName = paymentName;
		this.details = details;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public double getFinalAmount() {
		return finalAmount;
	}
	
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	
	public String getPaymentName() {
		return paymentName;
	}
	
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	
	public List<UserOrderDetailsDTO> getDetails() {
		return details;
	}
	
	public void setDetails(List<UserOrderDetailsDTO> details) {
		this.details = details;
	}
}