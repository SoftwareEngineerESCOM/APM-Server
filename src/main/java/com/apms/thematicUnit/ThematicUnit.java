package com.apms.thematicUnit;

import java.util.List;

import javax.persistence.*;

import com.apms.bibliography.Bibliography;
import com.apms.content.Content;

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
	@Column
	private String competenceUnit;
	@Column
	private String learningStrategy;
	@ManyToOne
	@JoinColumn
	private LearningUnit learningUnit;
	@ManyToOne
	@JoinColumn
	private Topic topic;
	@OneToOne
	@JoinColumn
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
