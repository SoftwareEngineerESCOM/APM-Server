package com.apms.syntheticProgram;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.apms.evaluationAccreditationUA.EvaluationAccreditationUA;
import com.apms.learningUnit.LearningUnit;
import com.apms.content.Content;

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
	@Column(nullable = false, length = 2000)
	private String didacticOrientation;

	@OneToOne
	@JoinColumn
	private LearningUnit learningUnit;

	@OneToOne
	@JoinColumn
	private EvaluationAccreditationUA evaluationAccreditationUA;
	
	@OneToMany
	@JoinColumn
	private List<Content> content;

	public SyntheticProgram() {
			
	}

	public SyntheticProgram(String regard, String didacticOrientation, LearningUnit learningUnit,
			EvaluationAccreditationUA evaluationAccreditationUA, List<Content> content) {
		super();
		this.regard = regard;
		this.didacticOrientation = didacticOrientation;
		this.learningUnit = learningUnit;
		this.evaluationAccreditationUA = evaluationAccreditationUA;
		this.content = content;
	}

}
