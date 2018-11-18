package com.apms.teachingProfile;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeachingProfileService {
    @Autowired
    private TeachingProfileRepository teachingProfileRepository;
    public List<TeachingProfile> getAll() {
        List<TeachingProfile> records = new ArrayList<>();
        teachingProfileRepository.findAll().forEach(records::add);
        return records;
    }
    public TeachingProfile getOne(Integer id) {
        return teachingProfileRepository.findById(id).get();
    }
    public void add(TeachingProfile TeachingProfile) {
        teachingProfileRepository.save(TeachingProfile);
    }
    public void update(TeachingProfile TeachingProfile) {
        // if exists updates otherwise inserts
        teachingProfileRepository.save(TeachingProfile);
    }
    public void delete(Integer id) {
        teachingProfileRepository.deleteById(id);
    }
}
