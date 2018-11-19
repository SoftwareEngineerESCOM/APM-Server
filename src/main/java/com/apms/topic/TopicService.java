package com.apms.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAll() {
		List<Topic> records = new ArrayList<>();
		topicRepository.findAll().forEach(records::add);
		return records;
	}

	public Topic getOne(Integer id) {
		return topicRepository.findById(id).isPresent() ? topicRepository.findById(id).get() : null;
	}

	public void add(Topic topic) {
		topicRepository.save(topic);
	}

	public void update(Topic topic) {
		// if exists updates otherwise inserts
		topicRepository.save(topic);
	}

	public void delete(Integer id) {
		topicRepository.deleteById(id);
	}
}
