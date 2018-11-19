package com.apms.studyPlan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyPlanService {

	@Autowired
	private StudyPlanRepository studyPlanRepository;

	public List<StudyPlan> getAll() {
		List<StudyPlan> records = new ArrayList<>();
		studyPlanRepository.findAll().forEach(records::add);
		return records;
	}

	public StudyPlan getOne(Integer id) {
		return studyPlanRepository.findById(id).isPresent() ? studyPlanRepository.findById(id).get() : null;
	}

	public void add(StudyPlan studyPlan) {
		studyPlanRepository.save(studyPlan);
	}

	public void update(StudyPlan studyPlan) {
		// if exists updates otherwise inserts
		studyPlanRepository.save(studyPlan);
	}

	public void delete(Integer id) {
		studyPlanRepository.deleteById(id);
	}

	public List<StudyPlan> getStudyPlansByAcademicProgramId(Integer id) {
		return studyPlanRepository.getStudyPlansByAcademicProgramId(id);
	}
}
