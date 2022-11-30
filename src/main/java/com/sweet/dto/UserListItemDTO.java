package com.sweet.dto;

public class UserListItemDTO {
	private int id;
	private String names;
	private String lastnames;
	private String rolname;
	private String phone;
	private String dni;
	
	public UserListItemDTO() {}
	
	public UserListItemDTO(int id, String names, String lastnames, String rolname, String phone, String dni) {
		super();
		this.id = id;
		this.names = names;
		this.lastnames = lastnames;
		this.rolname = rolname;
		this.phone = phone;
		this.dni = dni;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getLastnames() {
		return lastnames;
	}
	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}
	public String getRolname() {
		return rolname;
	}
	public void setRolname(String rolname) {
		this.rolname = rolname;
	}	
}