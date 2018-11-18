package com.apms.evaluationAccreditationUA;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
        return evaluationAccreditationUARepository.findById(id).get();
    }
    public void add(EvaluationAccreditationUA EvaluationAccreditationUA) {
        evaluationAccreditationUARepository.save(EvaluationAccreditationUA);
    }
    public void update(EvaluationAccreditationUA EvaluationAccreditationUA) {
        // if exists updates otherwise inserts
        evaluationAccreditationUARepository.save(EvaluationAccreditationUA);
    }
    public void delete(Integer id) {
        evaluationAccreditationUARepository.deleteById(id);
    }
}
