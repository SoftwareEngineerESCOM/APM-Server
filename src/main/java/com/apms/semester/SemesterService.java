package com.apms.semester;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemesterService {
	
    @Autowired
    private SemesterRepository semesterRepository;

    public List<Semester> getAll() {
        List<Semester> records = new ArrayList<>();
        semesterRepository.findAll().forEach(records::add);
        return records;
    }

    public Semester getOne(Integer id) {
        return semesterRepository.findById(id).get();
    }

    public void add(Semester semester) {
        semesterRepository.save(semester);
    }

    public void update(Semester semester) {
        // if exists updates otherwise inserts
        semesterRepository.save(semester);
    }

    public void delete(Integer id) {
        semesterRepository.deleteById(id);
    }
}
