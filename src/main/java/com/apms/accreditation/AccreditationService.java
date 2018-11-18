package com.apms.accreditation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccreditationService {
    @Autowired
    private AccreditationRepository accreditationRepository;
    public List<Accreditation> getAll() {
        List<Accreditation> records = new ArrayList<>();
        accreditationRepository.findAll().forEach(records::add);
        return records;
    }
    public Accreditation getOne(Integer id) {
        return accreditationRepository.findById(id).get();
    }
    public void add(Accreditation Accreditation) {
        accreditationRepository.save(Accreditation);
    }
    public void update(Accreditation Accreditation) {
        // if exists updates otherwise inserts
        accreditationRepository.save(Accreditation);
    }
    public void delete(Integer id) {
        accreditationRepository.deleteById(id);
    }
}
