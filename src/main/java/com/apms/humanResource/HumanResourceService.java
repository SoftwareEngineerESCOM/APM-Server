package com.apms.humanResource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return humanResourceRepository.findById(id).isPresent() ? humanResourceRepository.findById(id).get() : null;
	}

	public HumanResource getOne(String name, String first_surname, String second_surname) {
		return humanResourceRepository.getByName(name, first_surname, second_surname);
	}

	public HumanResource add(HumanResource humanResource) {
		return humanResourceRepository.save(humanResource);
	}

	public HumanResource update(HumanResource humanResource) {
		// if exists updates otherwise inserts
		return humanResourceRepository.save(humanResource);
	}

	public void delete(Integer id) {
		humanResourceRepository.deleteById(id);
	}

	public List<HumanResource> getHumanResourcesByWorkplaceIdAndPositionId(Integer workplace_Id, Integer position_Id) {
		return humanResourceRepository.getHumanResourcesByWorkplaceIdAndPositionId(workplace_Id, position_Id);
	}

	public List<HumanResource> getHumanResourcesByWorkplaceId(Integer id) {
		return humanResourceRepository.getHumanResourcesByWorkplaceId(id);
	}
}
