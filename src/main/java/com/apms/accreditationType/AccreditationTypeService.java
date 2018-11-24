package com.apms.accreditationType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccreditationTypeService {

	@Autowired
	private AccreditationTypeRepository accreditationRepository;

	public List<AccreditationType> getAll() {
		List<AccreditationType> records = new ArrayList<>();
		accreditationRepository.findAll().forEach(records::add);
		return records;
	}

	public AccreditationType getOne(Integer id) {
		return accreditationRepository.findById(id).isPresent() ? accreditationRepository.findById(id).get() : null;
	}

	public void add(AccreditationType accreditation) {
		accreditationRepository.save(accreditation);
	}

	public void update(AccreditationType accreditation) {
		// if exists updates otherwise inserts
		accreditationRepository.save(accreditation);
	}

	public void delete(Integer id) {
		accreditationRepository.deleteById(id);
	}
}
