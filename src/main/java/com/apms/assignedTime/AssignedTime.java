package com.apms.assignedTime;

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
public class AssignedTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private double theoreticalHourWeek;
	@Column(nullable = false)
	private double PracticeHourWeek;
	@Column(nullable = false)
	private double theoreticalHourSemester;
	@Column(nullable = false)
	private double practiceHourSemester;
	@Column(nullable = false)
	private double automaticTeaching;
	@Column(nullable = false)
	private double totalSemsterHour;

	public AssignedTime() {

	}
}
