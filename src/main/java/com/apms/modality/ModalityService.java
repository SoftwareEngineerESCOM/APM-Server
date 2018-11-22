package com.apms.modality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ModalityService {

	@Autowired
	private ModalityRepository modalityRepository;

	public List<Modality> getAll() {
		List<Modality> records = new ArrayList<>();
		modalityRepository.findAll().forEach(records::add);
		return records;
	}

	public Modality getOne(Integer id) {
		return modalityRepository.findById(id).isPresent() ? modalityRepository.findById(id).get() : null;
	}

	public void add(Modality modality) {
		modalityRepository.save(modality);
	}

	public Modality update(Modality modality) {
		// if exists updates otherwise inserts
		return modalityRepository.save(modality);
	}

	public void delete(Integer id) {
		modalityRepository.deleteById(id);
	}
}
