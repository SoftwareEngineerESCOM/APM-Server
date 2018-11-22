package com.apms.task;

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
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private int state;
	@Column(nullable = false)
	private Date startDate;
	@Column(nullable = false)
	private Date expirationDate;
	@Column(nullable = false)
	private String urlResource;
	@Column(nullable = false)
	private String description;
	
	public Task(Integer id, int state, Date startDate, Date expirationDate, String urlResource, String description) {
		this.id = id;
		this.state = state;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.urlResource = urlResource;
		this.description = description;
	}

	public Task() {
		
	}
	
}
