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
        return academicLevelRepository.findById(id).get();
    }
    public void add(AcademicLevel AcademicLevel) {
        academicLevelRepository.save(AcademicLevel);
    }
    public void update(AcademicLevel AcademicLevel) {
        // if exists updates otherwise inserts
        academicLevelRepository.save(AcademicLevel);
    }
    public void delete(Integer id) {
        academicLevelRepository.deleteById(id);
    }
}
