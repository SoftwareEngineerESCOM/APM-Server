package com.apms.practiceRelation;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.apms.learningUnit.LearningUnit;
import com.apms.practice.Practice;
import com.apms.practiceRelationEvaluation.PracticeRelationEvaluation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PracticeRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(length = 2000)
	private String accreditation;
	@Column
	private Double totalHours;
	@Column(nullable = false)
	private Boolean isFinished;
	@Column
	private String placeOfPractice;

	@OneToOne
	@JoinColumn(nullable = false)
	private LearningUnit learningUnit;

	@OneToMany
	@JoinColumn
	private List<Practice> practices;

	@OneToMany
	@JoinColumn
	private List<PracticeRelationEvaluation> practiceRelationEvaluations;

    public PracticeRelation() {
        
    }
}
