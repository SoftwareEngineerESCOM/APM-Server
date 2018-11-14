package com.apms.user;

import java.util.List;

import javax.persistence.*;

import com.apms.humanResource.HumanResource;
import com.apms.role.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_apms")
public class User {

	@Id
	private String id;
	@Column(nullable = false)
	private String token;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private boolean isAccountActive;

	@OneToOne
	@JoinColumn(nullable = false)
	private HumanResource humanResource;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;

	public User() {

	}

	public User(String id, String token, String password, boolean isAccountActive, HumanResource humanResource) {
		super();
		this.id = id;
		this.token = token;
		this.password = password;
		this.isAccountActive = isAccountActive;
		this.humanResource = humanResource;
	}

	
}