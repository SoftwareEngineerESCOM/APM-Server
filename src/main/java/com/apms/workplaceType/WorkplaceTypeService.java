package com.apms.workplaceType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkplaceTypeService {

	@Autowired
	private WorkplaceTypeRepository workplaceTypeRepository;

	public List<WorkplaceType> getAll() {
		List<WorkplaceType> records = new ArrayList<>();
		workplaceTypeRepository.findAll().forEach(records::add);
		return records;
	}

	public WorkplaceType getOne(Integer id) {
		return workplaceTypeRepository.findById(id).isPresent() ? workplaceTypeRepository.findById(id).get() : null;
	}

	public void add(WorkplaceType workplaceType) {
		workplaceTypeRepository.save(workplaceType);
	}

	public void update(WorkplaceType workplaceType) {
		// if exists updates otherwise inserts
		workplaceTypeRepository.save(workplaceType);
	}

	public void delete(Integer id) {
		workplaceTypeRepository.deleteById(id);
	}
}
