package com.apms.attitude;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	return attitudeRepository.findById(id).isPresent() ? attitudeRepository.findById(id).get() : null;
    }

    public Attitude add(Attitude attitude) {
        return attitudeRepository.save(attitude);
    }

    public void update(Attitude attitude) {
        // if exists updates otherwise inserts
        attitudeRepository.save(attitude);
    }

    public void delete(Integer id) {
        attitudeRepository.deleteById(id);
    }
}
