package com.apms.learningUnit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningUnitService {

	@Autowired
	private LearningUnitRepository learningUnitRepository;

	public List<LearningUnit> getAll() {
		List<LearningUnit> records = new ArrayList<>();
		learningUnitRepository.findAll().forEach(records::add);
		return records;
	}

	public LearningUnit getOne(Integer id) {
		return learningUnitRepository.findById(id).isPresent() ? learningUnitRepository.findById(id).get() : null;
	}

	public LearningUnit add(LearningUnit learningUnit) {
		return learningUnitRepository.save(learningUnit);
	}

	public LearningUnit update(LearningUnit learningUnit) {
		// if exists updates otherwise inserts
		return learningUnitRepository.save(learningUnit);
	}

	public void delete(Integer id) {
		learningUnitRepository.deleteById(id);
	}

	public List<LearningUnit> getLearningUnitsBySemesterId(Integer id) {
		return learningUnitRepository.getLearningUnitsBySemesterId(id);
	}

	public List<LearningUnit> getLearningUnitByNameAndSemesterId(String name, Integer semester_id) {
		return learningUnitRepository.getLearningUnitByNameAndSemesterId(name, semester_id);
	}

	public List<LearningUnit> getLearningUnitByNameAndStudyPlanId(String name, Integer study_plan_id) {
		String auxName = name.trim();
		String pattern = "(\\s)(\\s+)";
		String updated = auxName.replaceAll(pattern,"$1");
		return learningUnitRepository.getLearningUnitByNameAndStudyPlanId(updated, study_plan_id);
	}
}
