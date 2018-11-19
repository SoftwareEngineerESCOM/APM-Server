package com.apms.schoolingGrade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolingGradeService {

	@Autowired
	private SchoolingGradeRepository schoolingGradeRepository;

	public List<SchoolingGrade> getAll() {
		List<SchoolingGrade> records = new ArrayList<>();
		schoolingGradeRepository.findAll().forEach(records::add);
		return records;
	}

	public SchoolingGrade getOne(Integer id) {
		return schoolingGradeRepository.findById(id).isPresent() ? schoolingGradeRepository.findById(id).get() : null;
	}

	public void add(SchoolingGrade schoolingGrade) {
		schoolingGradeRepository.save(schoolingGrade);
	}

	public void update(SchoolingGrade schoolingGrade) {
		// if exists updates otherwise inserts
		schoolingGradeRepository.save(schoolingGrade);
	}

	public void delete(Integer id) {
		schoolingGradeRepository.deleteById(id);
	}
}
