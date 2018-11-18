package com.apms.bibliography;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliographyService {

	@Autowired
	private BibliographyRepository bibliographyRepository;

	public List<Bibliography> getAll() {
		List<Bibliography> records = new ArrayList<>();
		bibliographyRepository.findAll().forEach(records::add);
		return records;
	}

	public Bibliography getOne(Integer id) {
		return bibliographyRepository.findById(id).isPresent() ? bibliographyRepository.findById(id).get() : null;
	}

	public void add(Bibliography bibliography) {
		bibliographyRepository.save(bibliography);
	}

	public void update(Bibliography bibliography) {
		// if exists updates otherwise inserts
		bibliographyRepository.save(bibliography);
	}

	public void delete(Integer id) {
		bibliographyRepository.deleteById(id);
	}
}
