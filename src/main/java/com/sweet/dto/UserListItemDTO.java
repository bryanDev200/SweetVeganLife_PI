package com.sweet.dto;

public class UserListItemDTO {
	private int id;
	private String names;
	private String lastnames;
	private String rolname;
	
	public UserListItemDTO() {}
	
	public UserListItemDTO(int id, String names, String lastnames, String rolname) {
		super();
		this.id = id;
		this.names = names;
		this.lastnames = lastnames;
		this.rolname = rolname;
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