package com.sweet.entity;

	import java.util.HashSet;
	import java.util.Set;
	
	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_payment")
public class Payment {
	@Id
	@Column(name = "payment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	@Column(name = "payment_description")
	private String paymentDescription;
	
	@JsonBackReference
	@OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Order> orders = new HashSet<>();

	public Payment() {}
	
	public Payment(long paymentId) {
		super();
		this.paymentId = paymentId;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}	
}