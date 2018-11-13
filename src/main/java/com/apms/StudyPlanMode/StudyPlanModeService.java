package com.apms.StudyPlanMode;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyPlanModeService {
	
    @Autowired
    private StudyPlanModeRepository studyPlanModeRepository;

    public List<StudyPlanMode> getAll() {
        List<StudyPlanMode> records = new ArrayList<>();
        studyPlanModeRepository.findAll().forEach(records::add);
        return records;
    }

    public StudyPlanMode getOne(Long id) {
        return studyPlanModeRepository.findById(id).get();
    }

    public void add(StudyPlanMode studyPlanMode) {
        studyPlanModeRepository.save(studyPlanMode);
    }

    public void update(StudyPlanMode studyPlanMode) {
        // if exists updates otherwise inserts
        studyPlanModeRepository.save(studyPlanMode);
    }

    public void delete(Long id) {
        studyPlanModeRepository.deleteById(id);
    }
}
