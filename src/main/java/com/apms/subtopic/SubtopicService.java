package com.apms.subtopic;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubtopicService {
    @Autowired
    private SubtopicRepository subtopicRepository;
    public List<Subtopic> getAll() {
        List<Subtopic> records = new ArrayList<>();
        subtopicRepository.findAll().forEach(records::add);
        return records;
    }
    public Subtopic getOne(Integer id) {
        return subtopicRepository.findById(id).get();
    }
    public void add(Subtopic Subtopic) {
        subtopicRepository.save(Subtopic);
    }
    public void update(Subtopic Subtopic) {
        // if exists updates otherwise inserts
        subtopicRepository.save(Subtopic);
    }
    public void delete(Integer id) {
        subtopicRepository.deleteById(id);
    }
}
