package com.apms.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.apms.humanResource.HumanResource;
import com.apms.role.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_apms")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String token;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private boolean isAccountBlocked;
	@Column(nullable = false, unique = true)
	private String email;

	@OneToOne
	@JoinColumn(nullable = false)
	private HumanResource humanResource;

	@ManyToMany
	private List<Role> roles;

	public User() {

	}

	public User(Integer id, String token, String password, boolean isAccountBlocked, HumanResource humanResource) {
		super();
		this.id = id;
		this.token = token;
		this.password = password;
		this.isAccountBlocked = isAccountBlocked;
		this.humanResource = humanResource;
	}
	
	public User(User user) {
		super();
		this.id = user.getId();
		this.token = user.getToken();
		this.password = user.getPassword();
		this.isAccountBlocked = user.isAccountBlocked();
		this.humanResource = user.getHumanResource();
	}

}
