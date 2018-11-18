package com.apms.syntheticProgram;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class SyntheticProgramService {
    @Autowired
    private SyntheticProgramRepository syntheticProgramRepository;
    public List<SyntheticProgram> getAll() {
        List<SyntheticProgram> records = new ArrayList<>();
        syntheticProgramRepository.findAll().forEach(records::add);
        return records;
    }
    public SyntheticProgram getOne(Integer id) {
        return syntheticProgramRepository.findById(id).get();
    }
    public void add(SyntheticProgram SyntheticProgram) {
        syntheticProgramRepository.save(SyntheticProgram);
    }
    public void update(SyntheticProgram SyntheticProgram) {
        // if exists updates otherwise inserts
        syntheticProgramRepository.save(SyntheticProgram);
    }
    public void delete(Integer id) {
        syntheticProgramRepository.deleteById(id);
    }
}
