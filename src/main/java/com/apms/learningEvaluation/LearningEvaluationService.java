package com.apms.learningEvaluation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningEvaluationService {

	@Autowired
	private LearningEvaluationRepository learningEvaluationRepository;

	public List<LearningEvaluation> getAll() {
		List<LearningEvaluation> records = new ArrayList<>();
		learningEvaluationRepository.findAll().forEach(records::add);
		return records;
	}

	public LearningEvaluation getOne(Integer id) {
		return learningEvaluationRepository.findById(id).isPresent()
				? learningEvaluationRepository.findById(id).get()
				: null;
	}

	public LearningEvaluation add(LearningEvaluation learningEvaluation) {
		return learningEvaluationRepository.save(learningEvaluation);
	}

	public void update(LearningEvaluation learningEvaluation) {
		// if exists updates otherwise inserts
		learningEvaluationRepository.save(learningEvaluation);
	}

	public void delete(Integer id) {
		learningEvaluationRepository.deleteById(id);
	}
}
