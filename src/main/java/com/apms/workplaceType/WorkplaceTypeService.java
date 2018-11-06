package com.apms.workplaceType;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkplaceTypeService {
	
    @Autowired
    private WorkplaceTypeRepository workplaceTypeRepository;

    public List<WorkplaceType> getAll() {
        List<WorkplaceType> records = new ArrayList<>();
        workplaceTypeRepository.findAll().forEach(records::add);
        return records;
    }

    public WorkplaceType getOne(Long id) {
        return workplaceTypeRepository.findById(id).get();
    }

    public void add(WorkplaceType workplaceType) {
        workplaceTypeRepository.save(workplaceType);
    }

    public void update(WorkplaceType workplaceType) {
        // if exists updates otherwise inserts
        workplaceTypeRepository.save(workplaceType);
    }

    public void delete(Long id) {
        workplaceTypeRepository.deleteById(id);
    }
}
