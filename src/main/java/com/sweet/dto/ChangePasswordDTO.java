package com.sweet.dto;

public class ChangePasswordDTO {
	private String email;
	private String password;
	private String confirmPassword;
	
	public ChangePasswordDTO() {}
	
	public ChangePasswordDTO(String password, String confirmPassword, String email) {
		super();
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}