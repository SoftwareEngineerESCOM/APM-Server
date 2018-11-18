package com.apms.bibliography;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
        return bibliographyRepository.findById(id).get();
    }
    public void add(Bibliography Bibliography) {
        bibliographyRepository.save(Bibliography);
    }
    public void update(Bibliography Bibliography) {
        // if exists updates otherwise inserts
        bibliographyRepository.save(Bibliography);
    }
    public void delete(Integer id) {
        bibliographyRepository.deleteById(id);
    }
}
