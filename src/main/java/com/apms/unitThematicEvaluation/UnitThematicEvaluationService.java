package com.apms.unitThematicEvaluation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitThematicEvaluationService {

	@Autowired
	private UnitThematicEvaluationRepository unitThematicEvaluationRepository;

	public List<UnitThematicEvaluation> getAll() {
		List<UnitThematicEvaluation> records = new ArrayList<>();
		unitThematicEvaluationRepository.findAll().forEach(records::add);
		return records;
	}

	public UnitThematicEvaluation getOne(Integer id) {
		return unitThematicEvaluationRepository.findById(id).isPresent()
				? unitThematicEvaluationRepository.findById(id).get()
				: null;
	}

	public void add(UnitThematicEvaluation unitThematicEvaluation) {
		unitThematicEvaluationRepository.save(unitThematicEvaluation);
	}

	public void update(UnitThematicEvaluation unitThematicEvaluation) {
		// if exists updates otherwise inserts
		unitThematicEvaluationRepository.save(unitThematicEvaluation);
	}

	public void delete(Integer id) {
		unitThematicEvaluationRepository.deleteById(id);
	}
}
