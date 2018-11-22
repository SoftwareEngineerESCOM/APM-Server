package com.apms.workplace;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return workplaceRepository.findById(id).isPresent() ? workplaceRepository.findById(id).get() : null;
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

	public List<Workplace> getWorkplacesForUserId(Integer id) {
		return workplaceRepository.getWorkplacesForUserId(id);
	}
}
