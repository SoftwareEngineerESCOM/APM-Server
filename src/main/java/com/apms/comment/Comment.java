package com.apms.comment;

import java.sql.Date;

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
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private Date date;
	
	public Comment(Integer id, String description, Date date) {
		this.id = id;
		this.description = description;
		this.date = date;
	}

	public Comment() {
		
	}
	
}
