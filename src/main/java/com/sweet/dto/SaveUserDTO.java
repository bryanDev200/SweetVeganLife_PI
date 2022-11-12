package com.sweet.dto;

public class SaveUserDTO {
	private String docNumber;
	private String password;
	private String image;
	private String lastName;
	private String firstName;
	private String userName;
	private String phone;
	private int documentId;
	private int shoopId;
	private int rolId;
	private boolean enabled;
	
	public SaveUserDTO(String docNumber, String password, String image, String lastName, String firstName,
			String userName, String phone, int documentId, int shoopId, int rolId, boolean enabled) {
		super();
		this.docNumber = docNumber;
		this.password = password;
		this.image = image;
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.phone = phone;
		this.documentId = documentId;
		this.shoopId = shoopId;
		this.rolId = rolId;
		this.enabled = enabled;
	}
	
	public SaveUserDTO() {}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public int getShoopId() {
		return shoopId;
	}

	public void setShoopId(int shoopId) {
		this.shoopId = shoopId;
	}

	public int getRolId() {
		return rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}		
}