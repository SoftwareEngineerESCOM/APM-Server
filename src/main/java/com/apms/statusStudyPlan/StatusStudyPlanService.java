package com.apms.statusStudyPlan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusStudyPlanService {

    @Autowired
    private StatusStudyPlanRepository statusStudyPlanRepository;

    public List<StatusStudyPlan> getAll() {
        List<StatusStudyPlan> records = new ArrayList<>();
        statusStudyPlanRepository.findAll().forEach(records::add);
        return records;
    }

    public StatusStudyPlan getOne(Integer id) {
	return statusStudyPlanRepository.findById(id).isPresent() ? statusStudyPlanRepository.findById(id).get() : null;
    }

    public void add(StatusStudyPlan statusStudyPlan) {
        statusStudyPlanRepository.save(statusStudyPlan);
    }

    public void update(StatusStudyPlan statusStudyPlan) {
        // if exists updates otherwise inserts
        statusStudyPlanRepository.save(statusStudyPlan);
    }

    public void delete(Integer id) {
        statusStudyPlanRepository.deleteById(id);
    }
}
