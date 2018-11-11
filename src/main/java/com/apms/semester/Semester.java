package com.apms.semester;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.studyPlan.StudyPlan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private Integer SemesterNumber;
	@ManyToOne
	@JoinColumn(nullable = false)
	private StudyPlan studyPlan;

	public Semester() {
	}

	public Semester(Integer id, Integer semesterNumber, StudyPlan studyPlan) {
		super();
		this.id = id;
		SemesterNumber = semesterNumber;
		this.studyPlan = studyPlan;
	}

}
