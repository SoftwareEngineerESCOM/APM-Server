package com.apms.evaluationSystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationSystemService {

	@Autowired
	private EvaluationSystemRepository evaluationSystemRepository;

	public List<EvaluationSystem> getAll() {
		List<EvaluationSystem> records = new ArrayList<>();
		evaluationSystemRepository.findAll().forEach(records::add);
		return records;
	}

	public EvaluationSystem getOne(Integer id) {
		return evaluationSystemRepository.findById(id).isPresent() ? evaluationSystemRepository.findById(id).get()
				: null;
	}

	public void add(EvaluationSystem evaluationSystem) {
		evaluationSystemRepository.save(evaluationSystem);
	}

	public void update(EvaluationSystem evaluationSystem) {
		// if exists updates otherwise inserts
		evaluationSystemRepository.save(evaluationSystem);
	}

	public void delete(Integer id) {
		evaluationSystemRepository.deleteById(id);
	}
}
