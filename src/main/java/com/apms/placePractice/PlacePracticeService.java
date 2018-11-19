package com.apms.placePractice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacePracticeService {

	@Autowired
	private PlacePracticeRepository placePracticeRepository;

	public List<PlacePractice> getAll() {
		List<PlacePractice> records = new ArrayList<>();
		placePracticeRepository.findAll().forEach(records::add);
		return records;
	}

	public PlacePractice getOne(Integer id) {
		return placePracticeRepository.findById(id).isPresent() ? placePracticeRepository.findById(id).get() : null;
	}

	public void add(PlacePractice placePractice) {
		placePracticeRepository.save(placePractice);
	}

	public void update(PlacePractice placePractice) {
		// if exists updates otherwise inserts
		placePracticeRepository.save(placePractice);
	}

	public void delete(Integer id) {
		placePracticeRepository.deleteById(id);
	}
}
