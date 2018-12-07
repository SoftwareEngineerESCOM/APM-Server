package com.apms.teachingProfile;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.apms.ability.Ability;
import com.apms.attitude.Attitude;
import com.apms.knowledge.Knowledge;
import com.apms.professionalExperience.ProfessionalExperience;
import com.apms.schoolingGrade.SchoolingGrade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TeachingProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String schoolingGrades;
	private String knowledges;
	private String professionalExperiences;
	private String ability;
	private String attitude;

	public TeachingProfile() {

	}

	public TeachingProfile(String schoolingGrades, String knowledges, String professionalExperiences,
			String ability, String attitude) {
		super();
		this.schoolingGrades = schoolingGrades;
		this.knowledges = knowledges;
		this.professionalExperiences = professionalExperiences;
		this.ability = ability;
		this.attitude = attitude;
		this.schoolingGrades = schoolingGrades;
	}
	
}
