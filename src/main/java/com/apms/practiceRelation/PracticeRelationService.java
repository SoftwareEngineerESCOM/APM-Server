package com.apms.practiceRelation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeRelationService {

    @Autowired
    private PracticeRelationRepository practiceRelationRepository;

    public List<PracticeRelation> getAll() {
        List<PracticeRelation> records = new ArrayList<>();
        practiceRelationRepository.findAll().forEach(records::add);
        return records;
    }

    public PracticeRelation getOne(Integer id) {
	return practiceRelationRepository.findById(id).isPresent() ? practiceRelationRepository.findById(id).get() : null;
    }

    public void add(PracticeRelation practiceRelation) {
        practiceRelationRepository.save(practiceRelation);
    }

    public void update(PracticeRelation practiceRelation) {
        // if exists updates otherwise inserts
        practiceRelationRepository.save(practiceRelation);
    }

    public void delete(Integer id) {
        practiceRelationRepository.deleteById(id);
    }
    
    public PracticeRelation getPracticeRelationsByLearningUnitId(Integer id) {
        return practiceRelationRepository.getPracticeRelationsByLearningUnitId(id);
    }
}
