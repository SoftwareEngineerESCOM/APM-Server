package com.apms.evaluationAccreditationUA;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.apms.accreditation.Accreditation;

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
	private List<Accreditation> accreditation;

	public EvaluationAccreditationUA() {

	}
}
