package com.apms.thematicUnit;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThematicUnitService {
    @Autowired
    private ThematicUnitRepository thematicUnitRepository;
    public List<ThematicUnit> getAll() {
        List<ThematicUnit> records = new ArrayList<>();
        thematicUnitRepository.findAll().forEach(records::add);
        return records;
    }
    public ThematicUnit getOne(Integer id) {
        return thematicUnitRepository.findById(id).get();
    }
    public void add(ThematicUnit ThematicUnit) {
        thematicUnitRepository.save(ThematicUnit);
    }
    public void update(ThematicUnit ThematicUnit) {
        // if exists updates otherwise inserts
        thematicUnitRepository.save(ThematicUnit);
    }
    public void delete(Integer id) {
        thematicUnitRepository.deleteById(id);
    }
}
