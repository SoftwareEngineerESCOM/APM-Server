package com.apms.learningUnit;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearningUnitService {
	
    @Autowired
    private LearningUnitRepository learningUnitRepository;

    public List<LearningUnit> getAll() {
        List<LearningUnit> records = new ArrayList<>();
        learningUnitRepository.findAll().forEach(records::add);
        return records;
    }

    public LearningUnit getOne(Integer id) {
        return learningUnitRepository.findById(id).get();
    }

    public void add(LearningUnit learningUnit) {
        learningUnitRepository.save(learningUnit);
    }

    public void update(LearningUnit learningUnit) {
        // if exists updates otherwise inserts
        learningUnitRepository.save(learningUnit);
    }

    public void delete(Integer id) {
        learningUnitRepository.deleteById(id);
    }
    
    public List<LearningUnit> getLearningUnitsBySemesterId(Integer id){
    	return learningUnitRepository.getLearningUnitsBySemesterId(id);
    }
}