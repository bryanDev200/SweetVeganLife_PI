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
@Table(name = "tb_user")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	@Column(name = "name_user")
	private String userFirstNames;
	@Column(name = "last_name_user")
	private String userLastName;
	@Column(name = "phone_user")
	private String userPhone;
	@Column(name = "image_user")
	private String userImage;
	@Column(name = "nickname_user")
	private String userName;
	@Column(name = "password_user")
	private String password;
	@Column(name = "doc_number_user")
	private String dniNumber;
	@Column(name = "enabled")
	private boolean enabledUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol userRol;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "document_id", nullable = false)
	private Document document;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shoop_id", nullable = false)
	private Shoop shoop;
	
	public User(long userId) {
		super();
		this.userId = userId;
	}
	
	public User(String userName, String password, Rol userRol) {
		super();
		this.userName = userName;
		this.password = password;
		this.userRol = userRol;
	}

	public User() {}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserFirstNames() {
		return userFirstNames;
	}

	public void setUserFirstNames(String userFirstNames) {
		this.userFirstNames = userFirstNames;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDniNumber() {
		return dniNumber;
	}

	public void setDniNumber(String dniNumber) {
		this.dniNumber = dniNumber;
	}

	public boolean isEnabledUser() {
		return enabledUser;
	}

	public void setEnabledUser(boolean enabledUser) {
		this.enabledUser = enabledUser;
	}

	public Rol getUserRol() {
		return userRol;
	}

	public void setUserRol(Rol userRol) {
		this.userRol = userRol;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Shoop getShoop() {
		return shoop;
	}

	public void setShoop(Shoop shoop) {
		this.shoop = shoop;
	}
}