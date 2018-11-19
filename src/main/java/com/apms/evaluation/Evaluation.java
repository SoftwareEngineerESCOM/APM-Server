package com.apms.evaluation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.apms.practicesRelation.PracticesRelation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private double percentage;
	@ManyToOne
	@JoinColumn(nullable = false)
	private PracticesRelation practicesRelation;

	public Evaluation() {
	}
}
