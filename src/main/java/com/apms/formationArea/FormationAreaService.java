package com.apms.formationArea;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormationAreaService {

	@Autowired
	private FormationAreaRepository formationAreaRepository;

	public List<FormationArea> getAll() {
		List<FormationArea> records = new ArrayList<>();
		formationAreaRepository.findAll().forEach(records::add);
		return records;
	}

	public FormationArea getOne(Integer id) {
		return formationAreaRepository.findById(id).isPresent() ? formationAreaRepository.findById(id).get() : null;
	}

	public void add(FormationArea formationArea) {
		formationAreaRepository.save(formationArea);
	}

	public void update(FormationArea formationArea) {
		// if exists updates otherwise inserts
		formationAreaRepository.save(formationArea);
	}

	public void delete(Integer id) {
		formationAreaRepository.deleteById(id);
	}
}
