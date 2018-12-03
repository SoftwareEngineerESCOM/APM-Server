package com.apms.practice;

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
public class Practice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int number;
	@Column(nullable = false)
	private double lenght;

	public Practice() {
	}

	public Practice(Integer id, String name, int number, double lenght) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.lenght = lenght;
	}
}
