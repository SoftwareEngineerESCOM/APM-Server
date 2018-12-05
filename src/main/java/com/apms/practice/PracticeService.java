package com.apms.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeService {

	@Autowired
	private PracticeRepository practiceRepository;

	public List<Practice> getAll() {
		List<Practice> records = new ArrayList<>();
		practiceRepository.findAll().forEach(records::add);
		return records;
	}

	public Practice getOne(Integer id) {
		return practiceRepository.findById(id).isPresent() ? practiceRepository.findById(id).get() : null;
	}

	public Practice add(Practice practice) {
		return practiceRepository.save(practice);
	}

	public void update(Practice practice) {
		// if exists updates otherwise inserts
		practiceRepository.save(practice);
	}

	public void delete(Integer id) {
		practiceRepository.deleteById(id);
	}
}
