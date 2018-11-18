package com.apms.content;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;
    public List<Content> getAll() {
        List<Content> records = new ArrayList<>();
        contentRepository.findAll().forEach(records::add);
        return records;
    }
    public Content getOne(Integer id) {
        return contentRepository.findById(id).get();
    }
    public void add(Content Content) {
        contentRepository.save(Content);
    }
    public void update(Content Content) {
        // if exists updates otherwise inserts
        contentRepository.save(Content);
    }
    public void delete(Integer id) {
        contentRepository.deleteById(id);
    }
}
