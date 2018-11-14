package com.apms.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Message {
	@Id
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;

	public Message() {
	}

	public Message(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
