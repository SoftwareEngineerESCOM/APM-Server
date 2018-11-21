package com.apms.humanResource;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String firstSurname;
	@Column(nullable = false)
	private String secondSurname;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Title title;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Position> position;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Workplace workplace;

	public HumanResource() {
	}

}
