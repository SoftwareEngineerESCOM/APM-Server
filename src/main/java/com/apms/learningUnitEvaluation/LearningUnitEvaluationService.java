package com.apms.learningUnitEvaluation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
        return learningUnitEvaluationRepository.findById(id).get();
    }
    public void add(LearningUnitEvaluation LearningUnitEvaluation) {
        learningUnitEvaluationRepository.save(LearningUnitEvaluation);
    }
    public void update(LearningUnitEvaluation LearningUnitEvaluation) {
        // if exists updates otherwise inserts
        learningUnitEvaluationRepository.save(LearningUnitEvaluation);
    }
    public void delete(Integer id) {
        learningUnitEvaluationRepository.deleteById(id);
    }
}
