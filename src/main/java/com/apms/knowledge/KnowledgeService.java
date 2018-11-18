package com.apms.knowledge;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class KnowledgeService {
    @Autowired
    private KnowledgeRepository knowledgeRepository;
    public List<Knowledge> getAll() {
        List<Knowledge> records = new ArrayList<>();
        knowledgeRepository.findAll().forEach(records::add);
        return records;
    }
    public Knowledge getOne(Integer id) {
        return knowledgeRepository.findById(id).get();
    }
    public void add(Knowledge Knowledge) {
        knowledgeRepository.save(Knowledge);
    }
    public void update(Knowledge Knowledge) {
        // if exists updates otherwise inserts
        knowledgeRepository.save(Knowledge);
    }
    public void delete(Integer id) {
        knowledgeRepository.deleteById(id);
    }
}
