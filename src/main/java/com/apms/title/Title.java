package com.apms.title;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Title {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String abbreviation;
	@Column(nullable = false)
	private String description;

	public Title() {

	}

	public Title(Integer id, String name, String abbreviation, String description) {
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
		this.description = description;
	}

}