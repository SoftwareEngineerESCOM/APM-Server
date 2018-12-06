package com.apms.extensiveProgram;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return extensiveProgramRepository.findById(id).isPresent() ? extensiveProgramRepository.findById(id).get()
				: null;
	}

	public ExtensiveProgram add(ExtensiveProgram extensiveProgram) {
		return extensiveProgramRepository.save(extensiveProgram);
	}

	public void update(ExtensiveProgram extensiveProgram) {
		// if exists updates otherwise inserts
		extensiveProgramRepository.save(extensiveProgram);
	}

	public void delete(Integer id) {
		extensiveProgramRepository.deleteById(id);
	}
}
