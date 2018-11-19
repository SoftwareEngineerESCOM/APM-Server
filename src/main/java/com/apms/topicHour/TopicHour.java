package com.apms.topicHour;

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
public class TopicHour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private double teachingTeory;
	@Column(nullable = false)
	private double teachingPractice;
	@Column(nullable = false)
	private double autonomous;

	public TopicHour() {

	}
}
