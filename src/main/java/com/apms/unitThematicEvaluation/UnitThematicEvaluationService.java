package com.apms.unitThematicEvaluation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
        return unitThematicEvaluationRepository.findById(id).get();
    }
    public void add(UnitThematicEvaluation UnitThematicEvaluation) {
        unitThematicEvaluationRepository.save(UnitThematicEvaluation);
    }
    public void update(UnitThematicEvaluation UnitThematicEvaluation) {
        // if exists updates otherwise inserts
        unitThematicEvaluationRepository.save(UnitThematicEvaluation);
    }
    public void delete(Integer id) {
        unitThematicEvaluationRepository.deleteById(id);
    }
}
