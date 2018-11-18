package com.apms.modality;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class ModalityService {
    @Autowired
    private ModalityRepository modalityRepository;
    public List<Modality> getAll() {
        List<Modality> records = new ArrayList<>();
        modalityRepository.findAll().forEach(records::add);
        return records;
    }
    public Modality getOne(Integer id) {
        return modalityRepository.findById(id).get();
    }
    public void add(Modality Modality) {
        modalityRepository.save(Modality);
    }
    public void update(Modality Modality) {
        // if exists updates otherwise inserts
        modalityRepository.save(Modality);
    }
    public void delete(Integer id) {
        modalityRepository.deleteById(id);
    }
}
