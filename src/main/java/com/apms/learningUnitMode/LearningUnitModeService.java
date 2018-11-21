package com.apms.learningUnitMode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningUnitModeService {

	@Autowired
	private LearningUnitModeRepository learningUnitModeRepository;

	public List<LearningUnitMode> getAll() {
		List<LearningUnitMode> records = new ArrayList<>();
		learningUnitModeRepository.findAll().forEach(records::add);
		return records;
	}

	public LearningUnitMode getOne(Integer id) {
		return learningUnitModeRepository.findById(id).isPresent() ? learningUnitModeRepository.findById(id).get() : null;
	}

	public void add(LearningUnitMode learningUnitMode) {
		learningUnitModeRepository.save(learningUnitMode);
	}

	public void update(LearningUnitMode learningUnitMode) {
		// if exists updates otherwise inserts
		learningUnitModeRepository.save(learningUnitMode);
	}

	public void delete(Integer id) {
		learningUnitModeRepository.deleteById(id);
	}
}
