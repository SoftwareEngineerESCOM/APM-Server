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

	public Bibliography getOne(String isbn) {
		return bibliographyRepository.findById(isbn).isPresent() ? bibliographyRepository.findById(isbn).get() : null;
	}

	public void add(Bibliography bibliography) {
            bibliographyRepository.save(bibliography);
	}

	public void update(Bibliography bibliography) {
		// if exists updates otherwise inserts
		bibliographyRepository.save(bibliography);
	}

	public void delete(String isbn) {
		bibliographyRepository.deleteById(isbn);
	}
}
