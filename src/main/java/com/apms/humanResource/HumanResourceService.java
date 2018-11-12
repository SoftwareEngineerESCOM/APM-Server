package com.apms.humanResource;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanResourceService {
	
    @Autowired
    private HumanResourceRepository humanResourceRepository;

    public List<HumanResource> getAll() {
        List<HumanResource> records = new ArrayList<>();
        humanResourceRepository.findAll().forEach(records::add);
        return records;
    }

    public HumanResource getOne(Integer id) {
        return humanResourceRepository.findById(id).get();
    }

    public void add(HumanResource humanResource) {
        humanResourceRepository.save(humanResource);
    }

    public void update(HumanResource humanResource) {
        // if exists updates otherwise inserts
        humanResourceRepository.save(humanResource);
    }

    public void delete(Integer id) {
        humanResourceRepository.deleteById(id);
    }
    
    public List<HumanResource> getHumanResourcesByWorkplaceIdAndPositionId(Integer workplace_Id, Integer position_Id){
    	return humanResourceRepository.getHumanResourcesByWorkplaceIdAndPositionId(workplace_Id, position_Id);
    }
}
