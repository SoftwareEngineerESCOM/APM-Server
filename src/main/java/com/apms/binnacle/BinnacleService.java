package com.apms.binnacle;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinnacleService {
	@Autowired
	private BinnacleRepository binnacleRepository;

	public List<Binnacle> getAll() {
		List<Binnacle> records = new ArrayList<>();
		binnacleRepository.findAll().forEach(records::add);
		return records;
	}

	public Binnacle getOne(Integer id) {
		return binnacleRepository.findById(id).isPresent() ? binnacleRepository.findById(id).get() : null;
	}

	public void add(Binnacle modality) {
		binnacleRepository.save(modality);
	}

	public Binnacle update(Binnacle modality) {
		// if exists updates otherwise inserts
		return binnacleRepository.save(modality);
	}

	public void delete(Integer id) {
		binnacleRepository.deleteById(id);
	}
}
