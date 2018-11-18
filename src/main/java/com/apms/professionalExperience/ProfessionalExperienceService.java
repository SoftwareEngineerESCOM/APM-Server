package com.apms.professionalExperience;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalExperienceService {
    @Autowired
    private ProfessionalExperienceRepository professionalExperienceRepository;
    public List<ProfessionalExperience> getAll() {
        List<ProfessionalExperience> records = new ArrayList<>();
        professionalExperienceRepository.findAll().forEach(records::add);
        return records;
    }
    public ProfessionalExperience getOne(Integer id) {
        return professionalExperienceRepository.findById(id).get();
    }
    public void add(ProfessionalExperience ProfessionalExperience) {
        professionalExperienceRepository.save(ProfessionalExperience);
    }
    public void update(ProfessionalExperience ProfessionalExperience) {
        // if exists updates otherwise inserts
        professionalExperienceRepository.save(ProfessionalExperience);
    }
    public void delete(Integer id) {
        professionalExperienceRepository.deleteById(id);
    }
}
