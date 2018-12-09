package com.apms.thematicUnit;

import java.util.List;

import javax.persistence.*;

import com.apms.content.Content;
import com.apms.evaluationSystem.EvaluationSystem;
import com.apms.learningEvaluation.LearningEvaluation;
import com.apms.learningUnit.LearningUnit;
import com.apms.topic.Topic;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ThematicUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private boolean isFinished;
	@Column(length = 2000)
	private String competenceUnit;
	@Column(length = 2000)
	private String learningStrategy;
	@ManyToOne
	@JoinColumn(nullable=false)
	private LearningUnit learningUnit;
	@OneToOne
	@JoinColumn(nullable=false)
	private Content content;
	@OneToMany
	@JoinColumn
	private List<Topic> topics;
	@OneToMany
	@JoinColumn
	private List<LearningEvaluation> learningEvaluations;


	public ThematicUnit() {
	}
}
