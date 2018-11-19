package com.apms.practicesRelation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.apms.learningUnit.LearningUnit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PracticesRelation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(nullable = false)
	private LearningUnit learningUnit;

	public PracticesRelation() {
	}
}
