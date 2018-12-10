package com.apms.practice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.thematicUnit.ThematicUnit;

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
	private double length;
	
	@ManyToOne
	@JoinColumn
	private ThematicUnit thematicUnit;

	public Practice() {
	}
}
