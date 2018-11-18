package com.apms.topicHour;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicHourService {
    @Autowired
    private TopicHourRepository topicHourRepository;
    public List<TopicHour> getAll() {
        List<TopicHour> records = new ArrayList<>();
        topicHourRepository.findAll().forEach(records::add);
        return records;
    }
    public TopicHour getOne(Integer id) {
        return topicHourRepository.findById(id).get();
    }
    public void add(TopicHour TopicHour) {
        topicHourRepository.save(TopicHour);
    }
    public void update(TopicHour TopicHour) {
        // if exists updates otherwise inserts
        topicHourRepository.save(TopicHour);
    }
    public void delete(Integer id) {
        topicHourRepository.deleteById(id);
    }
}
