package com.apms.assignedTime;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssignedTimeService {
    @Autowired
    private AssignedTimeRepository assignedTimeRepository;
    public List<AssignedTime> getAll() {
        List<AssignedTime> records = new ArrayList<>();
        assignedTimeRepository.findAll().forEach(records::add);
        return records;
    }
    public AssignedTime getOne(Integer id) {
        return assignedTimeRepository.findById(id).get();
    }
    public void add(AssignedTime AssignedTime) {
        assignedTimeRepository.save(AssignedTime);
    }
    public void update(AssignedTime AssignedTime) {
        // if exists updates otherwise inserts
        assignedTimeRepository.save(AssignedTime);
    }
    public void delete(Integer id) {
        assignedTimeRepository.deleteById(id);
    }
}
