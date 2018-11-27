package com.apms.evaluationAccreditationUA;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	@JoinColumn
	private List<AccreditationType> accreditationType;
	
	@OneToMany
	@JoinColumn
	private List<EvaluationUA> evaluationUA;
	
	
	public EvaluationAccreditationUA() {

	}

	public EvaluationAccreditationUA(int id, List<AccreditationType> accreditationtype, List<EvaluationUA> evaluationUA) {
		this.id = id;
		this.evaluationUA = evaluationUA;
		this.accreditationType = accreditationtype;
	}
}
