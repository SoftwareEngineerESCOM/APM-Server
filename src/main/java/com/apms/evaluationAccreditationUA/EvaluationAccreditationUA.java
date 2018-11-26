package com.apms.evaluationAccreditationUA;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import com.apms.accreditationType.AccreditationType;
import com.apms.evaluationUA.EvaluationUA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EvaluationAccreditationUA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany
	@JoinColumn(nullable = false)
	private List<AccreditationType> accreditationType;
	
	@OneToMany
	@JoinColumn(nullable = false)
	private List<EvaluationUA> evaluationUA;
	
	
	public EvaluationAccreditationUA() {

	}
}
