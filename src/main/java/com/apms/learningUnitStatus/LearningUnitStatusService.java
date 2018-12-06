package com.apms.learningUnitStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningUnitStatusService {

    @Autowired
    private LearningUnitStatusRepository learningUnitStatusRepository;

    public List<LearningUnitStatus> getAll() {
        List<LearningUnitStatus> records = new ArrayList<>();
        learningUnitStatusRepository.findAll().forEach(records::add);
        return records;
    }

    public LearningUnitStatus getOne(Integer id) {
	return learningUnitStatusRepository.findById(id).isPresent() ? learningUnitStatusRepository.findById(id).get() : null;
    }

    public void add(LearningUnitStatus learningUnitStatus) {
        learningUnitStatusRepository.save(learningUnitStatus);
    }

    public void update(LearningUnitStatus learningUnitStatus) {
        // if exists updates otherwise inserts
        learningUnitStatusRepository.save(learningUnitStatus);
    }

    public void delete(Integer id) {
        learningUnitStatusRepository.deleteById(id);
    }
}
