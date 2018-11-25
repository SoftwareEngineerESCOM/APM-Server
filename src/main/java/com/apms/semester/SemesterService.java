package com.apms.semester;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterService {

	@Autowired
	private SemesterRepository semesterRepository;

	public List<Semester> getAll() {
		List<Semester> records = new ArrayList<>();
		semesterRepository.findAll().forEach(records::add);
		return records;
	}

	public Semester getOne(Integer id) {
		return semesterRepository.findById(id).isPresent() ? semesterRepository.findById(id).get() : null;
	}

	public void add(Semester semester) {
		semesterRepository.save(semester);
	}

	public void update(Semester semester) {
		// if exists updates otherwise inserts
		semesterRepository.save(semester);
	}

	public void delete(Integer id) {
		semesterRepository.deleteById(id);
	}

	public List<Semester> getSemestersByStudyPlanId(Integer id) {
		return semesterRepository.getSemestersByStudyPlanId(id);
	}

	public Semester getMaxSemesterNumberByStudyPlanId(Integer id) {
		return semesterRepository.getMaxSemesterNumberByStudyPlanId(id);
	}
}
