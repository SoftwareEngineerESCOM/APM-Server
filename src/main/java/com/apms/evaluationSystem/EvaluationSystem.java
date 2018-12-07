package com.apms.evaluationSystem;

import javax.persistence.*;

import com.apms.thematicUnit.ThematicUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EvaluationSystem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = true, length = 100)
	private String evaluationProcedure;
	@Column(nullable = false)
	private double percentage;
	@Column(nullable = false)
	private int period;

	public EvaluationSystem() {
		
	}
}
