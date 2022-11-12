package com.sweet.entity;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	@Column(name = "order_number")
	private int orderNumber;
	@Column(name = "order_date")
	private String orderDate;
	@Column(name = "order_state")
	private String orderState;
	@Column(name = "final_amount")
	private double finalAmount;
	@Column(name = "creation_date")
	private String creationDate;
	@Column(name = "creation_user")
	private String creationUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shoop_id", nullable = false)
	private Shoop shoop;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id", nullable = false)
	private Payment payment;
	
	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderState() {
		return orderState;
	}
	
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	public double getFinalAmount() {
		return finalAmount;
	}
	
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getCreationUser() {
		return creationUser;
	}
	
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	
	public Shoop getShoop() {
		return shoop;
	}
	
	public void setShoop(Shoop shoop) {
		this.shoop = shoop;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}	
}