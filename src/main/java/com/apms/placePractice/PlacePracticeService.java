package com.apms.placePractice;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlacePracticeService {
    @Autowired
    private PlacePracticeRepository placePracticeRepository;
    public List<PlacePractice> getAll() {
        List<PlacePractice> records = new ArrayList<>();
        placePracticeRepository.findAll().forEach(records::add);
        return records;
    }
    public PlacePractice getOne(Integer id) {
        return placePracticeRepository.findById(id).get();
    }
    public void add(PlacePractice PlacePractice) {
        placePracticeRepository.save(PlacePractice);
    }
    public void update(PlacePractice PlacePractice) {
        // if exists updates otherwise inserts
        placePracticeRepository.save(PlacePractice);
    }
    public void delete(Integer id) {
        placePracticeRepository.deleteById(id);
    }
}
