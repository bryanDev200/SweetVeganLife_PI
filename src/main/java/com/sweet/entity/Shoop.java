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

@Entity
@Table(name = "tb_shoop")
public class Shoop {
	@Id
	@Column(name = "shoop_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shoopId;
	@Column(name = "shoop_address")
	private String address;
	@Column(name = "shoop_name")
	private String shoopName;
	@Column(name = "shoop_phone")
	private String shoopPhone;
	@Column(name = "shoop_number")
	private int shoopNumber;
	
	@OneToMany(mappedBy = "shoop", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<User> users = new HashSet<>();

	public Shoop(long shoopId) {
		this.shoopId = shoopId;
	}
	
	public Shoop() {}
	
	public long getShoopId() {
		return shoopId;
	}

	public void setShoopId(long shoopId) {
		this.shoopId = shoopId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShoopName() {
		return shoopName;
	}

	public void setShoopName(String shoopName) {
		this.shoopName = shoopName;
	}

	public String getShoopPhone() {
		return shoopPhone;
	}

	public void setShoopPhone(String shoopPhone) {
		this.shoopPhone = shoopPhone;
	}

	public int getShoopNumber() {
		return shoopNumber;
	}

	public void setShoopNumber(int shoopNumber) {
		this.shoopNumber = shoopNumber;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}	
}