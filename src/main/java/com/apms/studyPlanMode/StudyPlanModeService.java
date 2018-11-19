package com.apms.studyPlanMode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyPlanModeService {

	@Autowired
	private StudyPlanModeRepository studyPlanModeRepository;

	public List<StudyPlanMode> getAll() {
		List<StudyPlanMode> records = new ArrayList<>();
		studyPlanModeRepository.findAll().forEach(records::add);
		return records;
	}

	public StudyPlanMode getOne(Integer id) {
		return studyPlanModeRepository.findById(id).isPresent() ? studyPlanModeRepository.findById(id).get() : null;
	}

	public void add(StudyPlanMode studyPlanMode) {
		studyPlanModeRepository.save(studyPlanMode);
	}

	public void update(StudyPlanMode studyPlanMode) {
		// if exists updates otherwise inserts
		studyPlanModeRepository.save(studyPlanMode);
	}

	public void delete(Integer id) {
		studyPlanModeRepository.deleteById(id);
	}
}
