package com.apms.studyPlan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.academicProgram.AcademicProgram;
import com.apms.modality.Modality;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudyPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private Integer year;
	@Column(nullable = false)
	private Double totalTEPICCredits;
	@Column(nullable = false)
	private Double totalSATCACredits;
	@Column(nullable = false)
	private Double totalTheoryHours;
	@Column(nullable = false)
	private Double totalPracticeHours;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Modality modality;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private AcademicProgram academicProgram;

	public StudyPlan() {

	}
}
