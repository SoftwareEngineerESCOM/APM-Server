package com.apms.teachingProfile;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TeachingProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Column(nullable = false, length=2000)
	private String schoolingGrades;
    @Column(nullable = false, length=2000)
	private String knowledges;
    @Column(nullable = false, length=2000)
	private String professionalExperiences;
    @Column(nullable = false, length=2000)
	private String ability;
    @Column(nullable = false, length=2000)
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
