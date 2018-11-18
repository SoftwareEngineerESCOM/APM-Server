package com.apms.accreditation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccreditationService {

	@Autowired
	private AccreditationRepository accreditationRepository;

	public List<Accreditation> getAll() {
		List<Accreditation> records = new ArrayList<>();
		accreditationRepository.findAll().forEach(records::add);
		return records;
	}

	public Accreditation getOne(Integer id) {
		return accreditationRepository.findById(id).isPresent() ? accreditationRepository.findById(id).get() : null;
	}

	public void add(Accreditation accreditation) {
		accreditationRepository.save(accreditation);
	}

	public void update(Accreditation accreditation) {
		// if exists updates otherwise inserts
		accreditationRepository.save(accreditation);
	}

	public void delete(Integer id) {
		accreditationRepository.deleteById(id);
	}
}
