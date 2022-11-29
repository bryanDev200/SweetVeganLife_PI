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
@Table(name = "tb_subcategory")
public class SubCategory {
	@Id
	@Column(name = "subcategory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subCategoryId;
	@Column(name = "subcategory_name")
	private String subCategoryName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	public SubCategory() {}
	
	public SubCategory(long subCategoryId) {
		super();
		this.subCategoryId = subCategoryId;
	}

	public long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}	
}