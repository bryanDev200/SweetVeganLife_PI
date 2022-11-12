package com.sweet.entity;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	import javax.persistence.Table;

@Entity
@Table(name = "tb_permission")
public class Permission {
	@Id
	@Column(name = "permission_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long permissionId;
	@Column(name = "permission_name")
	private String permissionName;
	@Column(name = "permission_route")
	private String permissionRoute;

	public long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionRoute() {
		return permissionRoute;
	}

	public void setPermissionRoute(String permissionRoute) {
		this.permissionRoute = permissionRoute;
	}
}