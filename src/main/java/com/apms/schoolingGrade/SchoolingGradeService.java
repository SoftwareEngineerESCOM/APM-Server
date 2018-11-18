package com.apms.schoolingGrade;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolingGradeService {
    @Autowired
    private SchoolingGradeRepository schoolingGradeRepository;
    public List<SchoolingGrade> getAll() {
        List<SchoolingGrade> records = new ArrayList<>();
        schoolingGradeRepository.findAll().forEach(records::add);
        return records;
    }
    public SchoolingGrade getOne(Integer id) {
        return schoolingGradeRepository.findById(id).get();
    }
    public void add(SchoolingGrade SchoolingGrade) {
        schoolingGradeRepository.save(SchoolingGrade);
    }
    public void update(SchoolingGrade SchoolingGrade) {
        // if exists updates otherwise inserts
        schoolingGradeRepository.save(SchoolingGrade);
    }
    public void delete(Integer id) {
        schoolingGradeRepository.deleteById(id);
    }
}
