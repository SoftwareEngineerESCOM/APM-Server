package com.apms.practiceRelationEvaluation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeRelationEvaluationService {

    @Autowired
    private PracticeRelationEvaluationRepository practiceRelationEvaluationRepository;

    public List<PracticeRelationEvaluation> getAll() {
        List<PracticeRelationEvaluation> records = new ArrayList<>();
        practiceRelationEvaluationRepository.findAll().forEach(records::add);
        return records;
    }

    public PracticeRelationEvaluation getOne(Integer id) {
	return practiceRelationEvaluationRepository.findById(id).isPresent() ? practiceRelationEvaluationRepository.findById(id).get() : null;
    }

    public PracticeRelationEvaluation add(PracticeRelationEvaluation practiceRelationEvaluation) {
        return practiceRelationEvaluationRepository.save(practiceRelationEvaluation);
    }

    public PracticeRelationEvaluation update(PracticeRelationEvaluation practiceRelationEvaluation) {
        // if exists updates otherwise inserts
        return practiceRelationEvaluationRepository.save(practiceRelationEvaluation);
    }

    public void delete(Integer id) {
        practiceRelationEvaluationRepository.deleteById(id);
    }
}
