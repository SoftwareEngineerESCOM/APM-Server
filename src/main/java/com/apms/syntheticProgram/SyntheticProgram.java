package com.apms.syntheticProgram;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.apms.learningUnit.LearningUnit;
import com.apms.evaluationAccreditationUA.EvaluationAccreditationUA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class SyntheticProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String regard;
	@Column(nullable = false)
	private String didacticOrientation;

	@OneToOne
	@JoinColumn(nullable = false)
	private LearningUnit learningUnit;

	@OneToOne
	@JoinColumn(nullable = false)
	private EvaluationAccreditationUA evaluationAccreditationUA;

	public SyntheticProgram() {

	}
}
