package com.apms.evaluationSystem;

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
public class EvaluationSystem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = true, length = 100)
	private String evaluationProcedure;
	@Column(nullable = false)
	private double percentage;
	@Column(nullable = false)
	private int period;

	public EvaluationSystem() {
		
	}

	public EvaluationSystem(Integer id, String evaluationProcedure, double percentage, int period) {
		this.id = id;
		this.evaluationProcedure = evaluationProcedure;
		this.percentage = percentage;
		this.period = period;
	}
}
