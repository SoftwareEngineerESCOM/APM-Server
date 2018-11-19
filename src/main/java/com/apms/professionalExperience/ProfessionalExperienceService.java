package com.apms.professionalExperience;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalExperienceService {

	@Autowired
	private ProfessionalExperienceRepository professionalExperienceRepository;

	public List<ProfessionalExperience> getAll() {
		List<ProfessionalExperience> records = new ArrayList<>();
		professionalExperienceRepository.findAll().forEach(records::add);
		return records;
	}

	public ProfessionalExperience getOne(Integer id) {
		return professionalExperienceRepository.findById(id).isPresent()
				? professionalExperienceRepository.findById(id).get()
				: null;
	}

	public void add(ProfessionalExperience professionalExperience) {
		professionalExperienceRepository.save(professionalExperience);
	}

	public void update(ProfessionalExperience professionalExperience) {
		// if exists updates otherwise inserts
		professionalExperienceRepository.save(professionalExperience);
	}

	public void delete(Integer id) {
		professionalExperienceRepository.deleteById(id);
	}
}
