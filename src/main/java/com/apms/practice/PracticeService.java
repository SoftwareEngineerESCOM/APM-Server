package com.apms.practice;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class PracticeService {
    @Autowired
    private PracticeRepository practiceRepository;
    public List<Practice> getAll() {
        List<Practice> records = new ArrayList<>();
        practiceRepository.findAll().forEach(records::add);
        return records;
    }
    public Practice getOne(Integer id) {
        return practiceRepository.findById(id).get();
    }
    public void add(Practice Practice) {
        practiceRepository.save(Practice);
    }
    public void update(Practice Practice) {
        // if exists updates otherwise inserts
        practiceRepository.save(Practice);
    }
    public void delete(Integer id) {
        practiceRepository.deleteById(id);
    }
}
