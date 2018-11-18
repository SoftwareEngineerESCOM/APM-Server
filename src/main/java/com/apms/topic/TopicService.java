package com.apms.topic;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    public List<Topic> getAll() {
        List<Topic> records = new ArrayList<>();
        topicRepository.findAll().forEach(records::add);
        return records;
    }
    public Topic getOne(Integer id) {
        return topicRepository.findById(id).get();
    }
    public void add(Topic Topic) {
        topicRepository.save(Topic);
    }
    public void update(Topic Topic) {
        // if exists updates otherwise inserts
        topicRepository.save(Topic);
    }
    public void delete(Integer id) {
        topicRepository.deleteById(id);
    }
}
