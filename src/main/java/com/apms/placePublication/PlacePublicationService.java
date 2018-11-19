package com.apms.placePublication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacePublicationService {

	@Autowired
	private PlacePublicationRepository placePublicationRepository;

	public List<PlacePublication> getAll() {
		List<PlacePublication> records = new ArrayList<>();
		placePublicationRepository.findAll().forEach(records::add);
		return records;
	}

	public PlacePublication getOne(Integer id) {
		return placePublicationRepository.findById(id).isPresent() ? placePublicationRepository.findById(id).get()
				: null;
	}

	public void add(PlacePublication placePublication) {
		placePublicationRepository.save(placePublication);
	}

	public void update(PlacePublication placePublication) {
		// if exists updates otherwise inserts
		placePublicationRepository.save(placePublication);
	}

	public void delete(Integer id) {
		placePublicationRepository.deleteById(id);
	}
}
