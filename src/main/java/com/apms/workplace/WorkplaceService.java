package com.apms.workplace;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkplaceService {
	
    @Autowired
    private WorkplaceRepository workplaceRepository;

    public List<Workplace> getAll() {
        List<Workplace> records = new ArrayList<>();
        workplaceRepository.findAll().forEach(records::add);
        return records;
    }

    public Workplace getOne(Integer id) {
        return workplaceRepository.findById(id).get();
    }

    public void add(Workplace workplace) {
        workplaceRepository.save(workplace);
    }

    public void update(Workplace workplace) {
        // if exists updates otherwise inserts
        workplaceRepository.save(workplace);
    }

    public void delete(Integer id) {
        workplaceRepository.deleteById(id);
    }
}
