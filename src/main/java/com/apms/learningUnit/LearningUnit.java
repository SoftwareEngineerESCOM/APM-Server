package com.apms.learningUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.formationArea.FormationArea;
import com.apms.semester.Semester;
import com.apms.learningUnitStatus.LearningUnitStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LearningUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Double TEPICCredits;
	@Column(nullable = false)
	private Double SATCACredits;
	@Column(nullable = false)
	private Double theoryHoursPerWeek;
	@Column(nullable = false)
	private Double practiceHoursPerWeek;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FormationArea formationArea;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Semester semester;
        @ManyToOne
        @JoinColumn(nullable = false)
        private LearningUnitStatus learningUnitStatus;

	public LearningUnit() {
	}

}
