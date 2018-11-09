package com.apms.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.apms.humanResource.HumanResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="user_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String token;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private boolean isAccountActive;
	@OneToOne
	@JoinColumn(nullable = false)
	private HumanResource humanResource;

	public User() {

	}

	public User(Integer id, String token, String password, boolean isAccountActive, HumanResource humanResource) {
		super();
		this.id = id;
		this.token = token;
		this.password = password;
		this.isAccountActive = isAccountActive;
		this.humanResource = humanResource;
	}

}