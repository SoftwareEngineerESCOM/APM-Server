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
	@Column(nullable = false)
	private double percentage;
	@Column(nullable = false)
	private int period;
	@Column
	private boolean isFinished;
	@OneToOne
	@JoinColumn
	private ThematicUnit thematicUnit;

	public EvaluationSystem() {
		
	}
}
