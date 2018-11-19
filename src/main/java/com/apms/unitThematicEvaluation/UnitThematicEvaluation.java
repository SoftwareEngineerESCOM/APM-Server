package com.apms.unitThematicEvaluation;

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
public class UnitThematicEvaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private double percentage;
	@Column(nullable = false)
	private String evaluationType;
	@ManyToOne
	@JoinColumn(nullable = false)
	private ThematicUnit thematicUnit;

	public UnitThematicEvaluation() {

	}
}
