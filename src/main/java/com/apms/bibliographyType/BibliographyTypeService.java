package com.apms.bibliographyType;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
        return bibliographyTypeRepository.findById(id).get();
    }
    public void add(BibliographyType BibliographyType) {
        bibliographyTypeRepository.save(BibliographyType);
    }
    public void update(BibliographyType BibliographyType) {
        // if exists updates otherwise inserts
        bibliographyTypeRepository.save(BibliographyType);
    }
    public void delete(Integer id) {
        bibliographyTypeRepository.deleteById(id);
    }
}
