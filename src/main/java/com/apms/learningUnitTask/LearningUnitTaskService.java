package com.apms.learningUnitTask;

import java.util.ArrayList;
import java.util.List;

import com.apms.learningUnit.LearningUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningUnitTaskService {

    @Autowired
    private LearningUnitTaskRepository learningUnitTaskRepository;

    public List<LearningUnitTask> getAll() {
        List<LearningUnitTask> records = new ArrayList<>();
        learningUnitTaskRepository.findAll().forEach(records::add);
        return records;
    }

    public LearningUnitTask getOne(Integer id) {
    	return learningUnitTaskRepository.findById(id).isPresent() ? learningUnitTaskRepository.findById(id).get() : null;
    }

    public void add(LearningUnitTask learningUnitTask) {
        learningUnitTaskRepository.save(learningUnitTask);
    }

    public void update(LearningUnitTask learningUnitTask) {
        // if exists updates otherwise inserts
        learningUnitTaskRepository.save(learningUnitTask);
    }

    /*public List<LearningUnitTask> learningUnitTasksByUserId(Integer id) {
        return learningUnitTaskRepository.learningUnitTasksByUserId(id);
    	//return null;
    }*/
    
    public List<LearningUnitTask> existUserLearningUnitByUserId(Integer id, Integer idLU){
        return learningUnitTaskRepository.existUserLearningUnitByUserId(id, idLU);
    }

    public void delete(Integer id) {
        learningUnitTaskRepository.deleteById(id);
    }

    public List<LearningUnitTask> getLearningUnitTasksByUserId(Integer id) {
        return learningUnitTaskRepository.getLearningUnitTasksByUserId(id);
        //return learningUnitTaskRepository.getLearningUnitTasksByUserId(id);
    }
}
