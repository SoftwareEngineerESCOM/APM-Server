package com.apms.evaluationUA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationUAService {

	@Autowired
	private EvaluationUARepository evaluationUARepository;

	public List<EvaluationUA> getAll() {
		List<EvaluationUA> records = new ArrayList<>();
		evaluationUARepository.findAll().forEach(records::add);
		return records;
	}

	public EvaluationUA getOne(Integer id) {
		return evaluationUARepository.findById(id).isPresent() ? evaluationUARepository.findById(id).get() : null;
	}

	public EvaluationUA add(EvaluationUA evaluationUA) {
		return evaluationUARepository.save(evaluationUA);
	}

	public EvaluationUA update(EvaluationUA evaluationUA) {
		// if exists updates otherwise inserts
		return evaluationUARepository.save(evaluationUA);
	}

	public void delete(Integer id) {
		evaluationUARepository.deleteById(id);
	}
}
