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
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private boolean isAccountActive;
	@OneToOne
	@JoinColumn(nullable = false)
	private HumanResource humanResource;

	public User() {

	}

	public User(Long id, String password, boolean isAccountActive, HumanResource humanResource) {
		this.id = id;
		this.password = password;
		this.isAccountActive = isAccountActive;
		this.humanResource = humanResource;
	}

}