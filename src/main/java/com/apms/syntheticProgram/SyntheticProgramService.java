package com.apms.syntheticProgram;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return syntheticProgramRepository.findById(id).isPresent() ? syntheticProgramRepository.findById(id).get()
				: null;
	}

	public SyntheticProgram add(SyntheticProgram syntheticProgram) {
		return syntheticProgramRepository.save(syntheticProgram);
	}

	public void update(SyntheticProgram syntheticProgram) {
		// if exists updates otherwise inserts
		syntheticProgramRepository.save(syntheticProgram);
	}

	public void delete(Integer id) {
		syntheticProgramRepository.deleteById(id);
	}
}
