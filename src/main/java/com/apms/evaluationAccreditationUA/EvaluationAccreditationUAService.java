package com.apms.evaluationAccreditationUA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationAccreditationUAService {

	@Autowired
	private EvaluationAccreditationUARepository evaluationAccreditationUARepository;

	public List<EvaluationAccreditationUA> getAll() {
		List<EvaluationAccreditationUA> records = new ArrayList<>();
		evaluationAccreditationUARepository.findAll().forEach(records::add);
		return records;
	}

	public EvaluationAccreditationUA getOne(Integer id) {
		return evaluationAccreditationUARepository.findById(id).isPresent()
				? evaluationAccreditationUARepository.findById(id).get()
				: null;
	}

	public void add(EvaluationAccreditationUA evaluationAccreditationUA) {
		evaluationAccreditationUARepository.save(evaluationAccreditationUA);
	}

	public void update(EvaluationAccreditationUA evaluationAccreditationUA) {
		// if exists updates otherwise inserts
		evaluationAccreditationUARepository.save(evaluationAccreditationUA);
	}

	public void delete(Integer id) {
		evaluationAccreditationUARepository.deleteById(id);
	}
}
