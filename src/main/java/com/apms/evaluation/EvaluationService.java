package com.apms.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

	@Autowired
	private EvaluationRepository evaluationRepository;

	public List<Evaluation> getAll() {
		List<Evaluation> records = new ArrayList<>();
		evaluationRepository.findAll().forEach(records::add);
		return records;
	}

	public Evaluation getOne(Integer id) {
		return evaluationRepository.findById(id).isPresent() ? evaluationRepository.findById(id).get() : null;
	}

	public void add(Evaluation evaluation) {
		evaluationRepository.save(evaluation);
	}

	public void update(Evaluation evaluation) {
		// if exists updates otherwise inserts
		evaluationRepository.save(evaluation);
	}

	public void delete(Integer id) {
		evaluationRepository.deleteById(id);
	}
}
