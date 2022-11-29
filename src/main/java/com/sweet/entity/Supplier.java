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
@Table(name = "tb_supplier")
public class Supplier {
	@Id
	@Column(name = "supplier_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierId;
	@Column(name = "supplier_name")
	private String supplierName;
	@Column(name = "supplier_phone")
	private String supplierPhone;
	@Column(name = "supplier_name_contact")
	private String supplierContactName;
	@Column(name = "suppllier_state")
	private boolean supplierState;
	
	@JsonBackReference
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> products = new HashSet<>();

	public Supplier() {}
	
	public Supplier(long supplierId) {
		super();
		this.supplierId = supplierId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public String getSupplierContactName() {
		return supplierContactName;
	}

	public void setSupplierContactName(String supplierContactName) {
		this.supplierContactName = supplierContactName;
	}

	public boolean isSupplierState() {
		return supplierState;
	}

	public void setSupplierState(boolean supplierState) {
		this.supplierState = supplierState;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}	
}