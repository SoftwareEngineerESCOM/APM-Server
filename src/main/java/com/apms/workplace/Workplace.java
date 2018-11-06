package com.apms.workplace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.workplaceType.WorkplaceType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Workplace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String abbreviation;
	@ManyToOne
	@JoinColumn(nullable = false)
	private WorkplaceType workplaceType;

	public Workplace() {
	}

	public Workplace(Long id, String name, String abbreviation, WorkplaceType workplaceType) {
		super();
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
		this.workplaceType = workplaceType;
	}

}