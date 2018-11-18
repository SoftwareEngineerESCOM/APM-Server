package com.apms.attitude;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttitudeService {
    @Autowired
    private AttitudeRepository attitudeRepository;
    public List<Attitude> getAll() {
        List<Attitude> records = new ArrayList<>();
        attitudeRepository.findAll().forEach(records::add);
        return records;
    }
    public Attitude getOne(Integer id) {
        return attitudeRepository.findById(id).get();
    }
    public void add(Attitude Attitude) {
        attitudeRepository.save(Attitude);
    }
    public void update(Attitude Attitude) {
        // if exists updates otherwise inserts
        attitudeRepository.save(Attitude);
    }
    public void delete(Integer id) {
        attitudeRepository.deleteById(id);
    }
}
