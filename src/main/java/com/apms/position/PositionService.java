package com.apms.position;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

	@Autowired
	private PositionRepository positionRepository;

	public List<Position> getAll() {
		List<Position> records = new ArrayList<>();
		positionRepository.findAll().forEach(records::add);
		return records;
	}

	public Position getOne(Integer id) {
		return positionRepository.findById(id).isPresent() ? positionRepository.findById(id).get() : null;
	}

	public void add(Position position) {
		positionRepository.save(position);
	}

	public void update(Position position) {
		// if exists updates otherwise inserts
		positionRepository.save(position);
	}

	public void delete(Integer id) {
		positionRepository.deleteById(id);
	}
}
