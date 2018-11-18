package com.apms.teaching;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeachingService {
    @Autowired
    private TeachingRepository teachingRepository;
    public List<Teaching> getAll() {
        List<Teaching> records = new ArrayList<>();
        teachingRepository.findAll().forEach(records::add);
        return records;
    }
    public Teaching getOne(Integer id) {
        return teachingRepository.findById(id).get();
    }
    public void add(Teaching Teaching) {
        teachingRepository.save(Teaching);
    }
    public void update(Teaching Teaching) {
        // if exists updates otherwise inserts
        teachingRepository.save(Teaching);
    }
    public void delete(Integer id) {
        teachingRepository.deleteById(id);
    }
}
