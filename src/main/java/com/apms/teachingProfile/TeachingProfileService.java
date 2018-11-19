package com.apms.teachingProfile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachingProfileService {

	@Autowired
	private TeachingProfileRepository teachingProfileRepository;

	public List<TeachingProfile> getAll() {
		List<TeachingProfile> records = new ArrayList<>();
		teachingProfileRepository.findAll().forEach(records::add);
		return records;
	}

	public TeachingProfile getOne(Integer id) {
		return teachingProfileRepository.findById(id).isPresent() ? teachingProfileRepository.findById(id).get() : null;
	}

	public void add(TeachingProfile teachingProfile) {
		teachingProfileRepository.save(teachingProfile);
	}

	public void update(TeachingProfile teachingProfile) {
		// if exists updates otherwise inserts
		teachingProfileRepository.save(teachingProfile);
	}

	public void delete(Integer id) {
		teachingProfileRepository.deleteById(id);
	}
}
