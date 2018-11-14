package com.apms.humanResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.position.Position;
import com.apms.title.Title;
import com.apms.workplace.Workplace;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HumanResource {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String firstSurname;
	@Column(nullable = false)
	private String secondSurname;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Title title;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Position position;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Workplace workplace;

	public HumanResource() {
	}

	public HumanResource(String id, String name, String firstSurname, String secondSurname, Title title,
						 Position position, Workplace workplace) {
		this.id = id;
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.title = title;
		this.position = position;
		this.workplace = workplace;
	}

}