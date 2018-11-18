package com.apms.academicProgram;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcademicProgramService {

	@Autowired
	private AcademicProgramRepository academicProgramRepository;

	public List<AcademicProgram> getAll() {
		List<AcademicProgram> records = new ArrayList<>();
		academicProgramRepository.findAll().forEach(records::add);
		return records;
	}

	public AcademicProgram getOne(Integer id) {
		return academicProgramRepository.findById(id).isPresent() ? academicProgramRepository.findById(id).get() : null;
	}

	public void add(AcademicProgram academicProgram) {
		academicProgramRepository.save(academicProgram);
	}

	public void update(AcademicProgram academicProgram) {
		// if exists updates otherwise inserts
		academicProgramRepository.save(academicProgram);
	}

	public void delete(Integer id) {
		academicProgramRepository.deleteById(id);
	}

	public List<AcademicProgram> getAcademicProgramsByWorkPlaceId(Integer id) {
		return academicProgramRepository.getAcademicProgramsByWorkPlaceId(id);
	}
}
