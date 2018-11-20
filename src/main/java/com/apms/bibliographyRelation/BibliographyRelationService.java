package com.apms.bibliographyRelation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliographyRelationService {

    @Autowired
    private BibliographyRelationRepository bibliographyRelationRepository;

    public List<BibliographyRelation> getAll() {
        List<BibliographyRelation> records = new ArrayList<>();
        bibliographyRelationRepository.findAll().forEach(records::add);
        return records;
    }

    public BibliographyRelation getOne(Integer id) {
	return bibliographyRelationRepository.findById(id).isPresent() ? bibliographyRelationRepository.findById(id).get() : null;
    }

    public void add(BibliographyRelation bibliographyRelation) {
        bibliographyRelationRepository.save(bibliographyRelation);
    }

    public void update(BibliographyRelation bibliographyRelation) {
        // if exists updates otherwise inserts
        bibliographyRelationRepository.save(bibliographyRelation);
    }

    public void delete(Integer id) {
        bibliographyRelationRepository.deleteById(id);
    }
}
