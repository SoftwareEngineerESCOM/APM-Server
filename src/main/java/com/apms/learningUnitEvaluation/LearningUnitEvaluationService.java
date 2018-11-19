package com.apms.learningUnitEvaluation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningUnitEvaluationService {

	@Autowired
	private LearningUnitEvaluationRepository learningUnitEvaluationRepository;

	public List<LearningUnitEvaluation> getAll() {
		List<LearningUnitEvaluation> records = new ArrayList<>();
		learningUnitEvaluationRepository.findAll().forEach(records::add);
		return records;
	}

	public LearningUnitEvaluation getOne(Integer id) {
		return learningUnitEvaluationRepository.findById(id).isPresent()
				? learningUnitEvaluationRepository.findById(id).get()
				: null;
	}

	public void add(LearningUnitEvaluation learningUnitEvaluation) {
		learningUnitEvaluationRepository.save(learningUnitEvaluation);
	}

	public void update(LearningUnitEvaluation learningUnitEvaluation) {
		// if exists updates otherwise inserts
		learningUnitEvaluationRepository.save(learningUnitEvaluation);
	}

	public void delete(Integer id) {
		learningUnitEvaluationRepository.deleteById(id);
	}
}
