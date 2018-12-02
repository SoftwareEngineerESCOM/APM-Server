package com.apms.subtopic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubtopicService {

	@Autowired
	private SubtopicRepository subtopicRepository;

	public List<Subtopic> getAll() {
		List<Subtopic> records = new ArrayList<>();
		subtopicRepository.findAll().forEach(records::add);
		return records;
	}

	public Subtopic getOne(Integer id) {
		return subtopicRepository.findById(id).isPresent() ? subtopicRepository.findById(id).get() : null;
	}

	public Subtopic add(Subtopic subtopic) {
		return subtopicRepository.save(subtopic);
	}

	public void update(Subtopic subtopic) {
		// if exists updates otherwise inserts
		subtopicRepository.save(subtopic);
	}

	public void delete(Integer id) {
		subtopicRepository.deleteById(id);
	}
}
