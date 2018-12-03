package com.apms.content;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

	@Autowired
	private ContentRepository contentRepository;

	public List<Content> getAll() {
		List<Content> records = new ArrayList<>();
		contentRepository.findAll().forEach(records::add);
		return records;
	}

	public Content getOne(Integer id) {
		return contentRepository.findById(id).isPresent() ? contentRepository.findById(id).get() : null;
	}

	public Content add(Content content) {
		return contentRepository.save(content);
	}

	public List<Content> addAll(List<Content> content) {
		return contentRepository.saveAll(content);
	}
	
	public Content update(Content content) {
		// if exists updates otherwise inserts
		return contentRepository.save(content);
	}

	public void delete(Integer id) {
		contentRepository.deleteById(id);
	}
	public List<Content> getContentByLearningUnit(Integer id) {
		return contentRepository.getContentByLearningUnit(id);
	}
}
