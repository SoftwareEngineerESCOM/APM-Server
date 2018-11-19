package com.apms.practicesRelation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticesRelationService {

	@Autowired
	private PracticesRelationRepository practicesRelationRepository;

	public List<PracticesRelation> getAll() {
		List<PracticesRelation> records = new ArrayList<>();
		practicesRelationRepository.findAll().forEach(records::add);
		return records;
	}

	public PracticesRelation getOne(Integer id) {
		return practicesRelationRepository.findById(id).isPresent() ? practicesRelationRepository.findById(id).get()
				: null;
	}

	public void add(PracticesRelation practicesRelation) {
		practicesRelationRepository.save(practicesRelation);
	}

	public void update(PracticesRelation practicesRelation) {
		// if exists updates otherwise inserts
		practicesRelationRepository.save(practicesRelation);
	}

	public void delete(Integer id) {
		practicesRelationRepository.deleteById(id);
	}
}
