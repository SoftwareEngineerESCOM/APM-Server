package com.apms.teaching;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachingService {

	@Autowired
	private TeachingRepository teachingRepository;

	public List<Teaching> getAll() {
		List<Teaching> records = new ArrayList<>();
		teachingRepository.findAll().forEach(records::add);
		return records;
	}

	public Teaching getOne(Integer id) {
		return teachingRepository.findById(id).isPresent() ? teachingRepository.findById(id).get() : null;
	}

	public void add(Teaching teaching) {
		teachingRepository.save(teaching);
	}

	public void update(Teaching teaching) {
		// if exists updates otherwise inserts
		teachingRepository.save(teaching);
	}

	public void delete(Integer id) {
		teachingRepository.deleteById(id);
	}
}
