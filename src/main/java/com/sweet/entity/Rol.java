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
	import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

@Entity
@Table(name = "tb_rol")
public class Rol {
	@Id
	@Column(name = "rol_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rolId;
	@Column(name = "rol_name")
	private String rolName;
	@Column(name = "rol_description")
	private String rolDescription;
	
	@OneToMany(mappedBy = "userRol", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<User> users = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "role_permission",
				joinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id"), 
			   inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "permission_id"))
	private Set<Permission> permissions = new HashSet<>();

	public Rol(long rolId) {
		this.rolId = rolId;
	}
	
	public Rol() {}
	
	public long getRolId() {
		return rolId;
	}

	public void setRolId(long rolId) {
		this.rolId = rolId;
	}

	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public String getRolDescription() {
		return rolDescription;
	}

	public void setRolDescription(String rolDescription) {
		this.rolDescription = rolDescription;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}	
}