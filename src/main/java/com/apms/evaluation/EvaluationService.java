package com.apms.evaluation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
        return evaluationRepository.findById(id).get();
    }
    public void add(Evaluation Evaluation) {
        evaluationRepository.save(Evaluation);
    }
    public void update(Evaluation Evaluation) {
        // if exists updates otherwise inserts
        evaluationRepository.save(Evaluation);
    }
    public void delete(Integer id) {
        evaluationRepository.deleteById(id);
    }
}
