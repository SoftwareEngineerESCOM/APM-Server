package com.apms.position;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionService {
	
    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAll() {
        List<Position> records = new ArrayList<>();
        positionRepository.findAll().forEach(records::add);
        return records;
    }

    public Position getOne(Long id) {
        return positionRepository.findById(id).get();
    }

    public void add(Position position) {
        positionRepository.save(position);
    }

    public void update(Position position) {
        // if exists updates otherwise inserts
        positionRepository.save(position);
    }

    public void delete(Long id) {
        positionRepository.deleteById(id);
    }
}
