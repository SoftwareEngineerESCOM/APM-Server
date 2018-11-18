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
public class TeachingProfile{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    
    @ManyToMany
	private List<SchoolingGrade> schoolingGrades;
    @ManyToMany
	private List<Knowledge> knowledges;
    @ManyToMany
	private List<ProfessionalExperience> professionalExperiences;
    @ManyToMany
	private List<Ability> ability;
    @ManyToMany
	private List<Attitude> attitude;
    
    public TeachingProfile(){

    }
}
