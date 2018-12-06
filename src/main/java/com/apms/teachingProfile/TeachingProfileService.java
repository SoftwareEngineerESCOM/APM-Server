package com.apms.teachingProfile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apms.ability.Ability;
import com.apms.attitude.Attitude;
import com.apms.knowledge.Knowledge;
import com.apms.professionalExperience.ProfessionalExperience;
import com.apms.schoolingGrade.SchoolingGrade;

@Service
public class TeachingProfileService {

	@Autowired
	private TeachingProfileRepository teachingProfileRepository;

	public List<TeachingProfile> getAll() {
		List<TeachingProfile> records = new ArrayList<>();
		teachingProfileRepository.findAll().forEach(records::add);
		return records;
	}

	public TeachingProfile getOne(Integer id) {
		return teachingProfileRepository.findById(id).isPresent() ? teachingProfileRepository.findById(id).get() : null;
	}

	public TeachingProfile add(TeachingProfile teachingProfile) {
		return teachingProfileRepository.save(teachingProfile);
	}

	public void update(TeachingProfile teachingProfile) {
		// if exists updates otherwise inserts
		teachingProfileRepository.save(teachingProfile);
	}

	public void delete(Integer id) {
		teachingProfileRepository.deleteById(id);
	}

	public TeachingProfile add(SchoolingGrade schoolingGrade, List<Knowledge> knowledges, List<Ability> ability,
			List<Attitude> attitude, List<ProfessionalExperience> professionalExperience) {
		// TODO Auto-generated method stub
		return null;
	}
}
