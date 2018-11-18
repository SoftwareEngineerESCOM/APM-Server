package com.apms.extensiveProgram;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExtensiveProgramService {
    @Autowired
    private ExtensiveProgramRepository extensiveProgramRepository;
    public List<ExtensiveProgram> getAll() {
        List<ExtensiveProgram> records = new ArrayList<>();
        extensiveProgramRepository.findAll().forEach(records::add);
        return records;
    }
    public ExtensiveProgram getOne(Integer id) {
        return extensiveProgramRepository.findById(id).get();
    }
    public void add(ExtensiveProgram ExtensiveProgram) {
        extensiveProgramRepository.save(ExtensiveProgram);
    }
    public void update(ExtensiveProgram ExtensiveProgram) {
        // if exists updates otherwise inserts
        extensiveProgramRepository.save(ExtensiveProgram);
    }
    public void delete(Integer id) {
        extensiveProgramRepository.deleteById(id);
    }
}
