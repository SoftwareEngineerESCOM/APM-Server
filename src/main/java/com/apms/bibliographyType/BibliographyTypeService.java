package com.apms.bibliographyType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliographyTypeService {

	@Autowired
	private BibliographyTypeRepository bibliographyTypeRepository;

	public List<BibliographyType> getAll() {
		List<BibliographyType> records = new ArrayList<>();
		bibliographyTypeRepository.findAll().forEach(records::add);
		return records;
	}

	public BibliographyType getOne(Integer id) {
		return bibliographyTypeRepository.findById(id).isPresent() ? bibliographyTypeRepository.findById(id).get()
				: null;
	}

	public void add(BibliographyType bibliographyType) {
		bibliographyTypeRepository.save(bibliographyType);
	}

	public void update(BibliographyType bibliographyType) {
		// if exists updates otherwise inserts
		bibliographyTypeRepository.save(bibliographyType);
	}

	public void delete(Integer id) {
		bibliographyTypeRepository.deleteById(id);
	}
}
