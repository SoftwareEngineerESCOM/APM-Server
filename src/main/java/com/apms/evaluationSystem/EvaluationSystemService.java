package com.apms.evaluationSystem;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
        return evaluationSystemRepository.findById(id).get();
    }
    public void add(EvaluationSystem EvaluationSystem) {
        evaluationSystemRepository.save(EvaluationSystem);
    }
    public void update(EvaluationSystem EvaluationSystem) {
        // if exists updates otherwise inserts
        evaluationSystemRepository.save(EvaluationSystem);
    }
    public void delete(Integer id) {
        evaluationSystemRepository.deleteById(id);
    }
}
