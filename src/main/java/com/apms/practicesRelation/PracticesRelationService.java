package com.apms.practicesRelation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class PracticesRelationService {
    @Autowired
    private PracticesRelationRepository practicesRelationRepository;
    public List<PracticesRelation> getAll() {
        List<PracticesRelation> records = new ArrayList<>();
        practicesRelationRepository.findAll().forEach(records::add);
        return records;
    }
    public PracticesRelation getOne(Integer id) {
        return practicesRelationRepository.findById(id).get();
    }
    public void add(PracticesRelation PracticesRelation) {
        practicesRelationRepository.save(PracticesRelation);
    }
    public void update(PracticesRelation PracticesRelation) {
        // if exists updates otherwise inserts
        practicesRelationRepository.save(PracticesRelation);
    }
    public void delete(Integer id) {
        practicesRelationRepository.deleteById(id);
    }
}
