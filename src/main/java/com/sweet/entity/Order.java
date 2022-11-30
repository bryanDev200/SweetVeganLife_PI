package com.sweet.entity;

	import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "order_state")
	private String orderState;
	@Column(name = "final_amount")
	private double finalAmount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shoop_id", nullable = false)
	private Shoop shoop;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_id", nullable = false)
	private Payment payment;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderDetail> details = new HashSet<>();
	
	public Order() {}
	
	public Order(long orderId) {
		super();
		this.orderId = orderId;
	}
	
	public Set<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(Set<OrderDetail> details) {
		this.details = details;
	}

	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
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