package com.apms.title;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleService {

	@Autowired
	private TitleRepository titleRepository;

	public List<Title> getAll() {
		List<Title> records = new ArrayList<>();
		titleRepository.findAll().forEach(records::add);
		return records;
	}

	public Title getOne(Integer id) {
		return titleRepository.findById(id).isPresent() ? titleRepository.findById(id).get() : null;
	}

	public void add(Title title) {
		titleRepository.save(title);
	}

	public void update(Title title) {
		// if exists updates otherwise inserts
		titleRepository.save(title);
	}

	public void delete(Integer id) {
		titleRepository.deleteById(id);
	}
}
