package com.apms.placePublication;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

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
        return placePublicationRepository.findById(id).get();
    }
    public void add(PlacePublication PlacePublication) {
        placePublicationRepository.save(PlacePublication);
    }
    public void update(PlacePublication PlacePublication) {
        // if exists updates otherwise inserts
        placePublicationRepository.save(PlacePublication);
    }
    public void delete(Integer id) {
        placePublicationRepository.deleteById(id);
    }
}
