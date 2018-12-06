package com.apms.assignedTime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignedTimeService {

	@Autowired
	private AssignedTimeRepository assignedTimeRepository;

	public List<AssignedTime> getAll() {
		List<AssignedTime> records = new ArrayList<>();
		assignedTimeRepository.findAll().forEach(records::add);
		return records;
	}

	public AssignedTime getOne(Integer id) {
		return assignedTimeRepository.findById(id).isPresent() ? assignedTimeRepository.findById(id).get() : null;
	}

	public AssignedTime add(AssignedTime assignedTime) {
		return assignedTimeRepository.save(assignedTime);
	}

	public void update(AssignedTime assignedTime) {
		// if exists updates otherwise inserts
		assignedTimeRepository.save(assignedTime);
	}

	public void delete(Integer id) {
		assignedTimeRepository.deleteById(id);
	}
}
