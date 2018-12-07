package com.apms.academy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademyService {

    @Autowired
    private AcademyRepository academyRepository;

    public List<Academy> getAll() {
        List<Academy> records = new ArrayList<>();
        academyRepository.findAll().forEach(records::add);
        return records;
    }

    public Academy getOne(Integer id) {
	return academyRepository.findById(id).isPresent() ? academyRepository.findById(id).get() : null;
    }

    public void add(Academy academy) {
        academyRepository.save(academy);
    }

    public void update(Academy academy) {
        // if exists updates otherwise inserts
        academyRepository.save(academy);
    }

    public void delete(Integer id) {
        academyRepository.deleteById(id);
    }
}
