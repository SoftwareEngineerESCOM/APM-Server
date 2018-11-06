package com.apms.workplace;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn
	private List<WorkplaceType> workplaceTypes = new ArrayList<>();

	public Workplace() {
	}

	public Workplace(Long id, String name, String abbreviation, List<WorkplaceType> workplaceTypes) {
		super();
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
		this.workplaceTypes = workplaceTypes;
	}

}