package com.sweet.entity;

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
@Table(name = "tb_product")
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_description")
	private String productDescription;
	@Column(name = "product_price")
	private double productPrice;
	@Column(name = "product_stock")
	private int productStock;
	@Column(name = "product_state")
	private boolean productState;
	@Column(name = "creation_date")
	private String creationDate;
	@Column(name = "modification_date")
	private String modificationDate;
	@Column(name = "creation_user")
	private String creationUser;
	@Column(name = "modification_user")
	private String modificationUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategory_id", nullable = false)
	private SubCategory subCategory;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProductImage> images = new HashSet<>();
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getProductStock() {
		return productStock;
	}
	
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	public boolean isProductState() {
		return productState;
	}
	
	public void setProductState(boolean productState) {
		this.productState = productState;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getModificationDate() {
		return modificationDate;
	}
	
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	public String getCreationUser() {
		return creationUser;
	}
	
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	
	public String getModificationUser() {
		return modificationUser;
	}
	
	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public SubCategory getSubCategory() {
		return subCategory;
	}
	
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Set<ProductImage> getImages() {
		return images;
	}

	public void setImages(Set<ProductImage> images) {
		this.images = images;
	}	
}