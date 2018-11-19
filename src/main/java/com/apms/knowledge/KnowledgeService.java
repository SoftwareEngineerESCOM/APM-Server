package com.apms.knowledge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeService {

	@Autowired
	private KnowledgeRepository knowledgeRepository;

	public List<Knowledge> getAll() {
		List<Knowledge> records = new ArrayList<>();
		knowledgeRepository.findAll().forEach(records::add);
		return records;
	}

	public Knowledge getOne(Integer id) {
		return knowledgeRepository.findById(id).isPresent() ? knowledgeRepository.findById(id).get() : null;
	}

	public void add(Knowledge knowledge) {
		knowledgeRepository.save(knowledge);
	}

	public void update(Knowledge knowledge) {
		// if exists updates otherwise inserts
		knowledgeRepository.save(knowledge);
	}

	public void delete(Integer id) {
		knowledgeRepository.deleteById(id);
	}
}
