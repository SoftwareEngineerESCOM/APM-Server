package com.apms.academicLevel;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcademicLevelService {

    @Autowired
    private AcademicLevelRepository academicLevelRepository;

    public List<AcademicLevel> getAll() {
        List<AcademicLevel> records = new ArrayList<>();
        academicLevelRepository.findAll().forEach(records::add);
        return records;
    }

    public AcademicLevel getOne(Integer id) {
	return academicLevelRepository.findById(id).isPresent() ? academicLevelRepository.findById(id).get() : null;
    }

    public AcademicLevel add(AcademicLevel academicLevel) {
        return academicLevelRepository.save(academicLevel);
    }

    public void update(AcademicLevel academicLevel) {
        // if exists updates otherwise inserts
        academicLevelRepository.save(academicLevel);
    }

    public void delete(Integer id) {
        academicLevelRepository.deleteById(id);
    }
}
