package com.apms.topicHour;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicHourService {

	@Autowired
	private TopicHourRepository topicHourRepository;

	public List<TopicHour> getAll() {
		List<TopicHour> records = new ArrayList<>();
		topicHourRepository.findAll().forEach(records::add);
		return records;
	}

	public TopicHour getOne(Integer id) {
		return topicHourRepository.findById(id).isPresent() ? topicHourRepository.findById(id).get() : null;
	}

	public void add(TopicHour topicHour) {
		topicHourRepository.save(topicHour);
	}

	public void update(TopicHour topicHour) {
		// if exists updates otherwise inserts
		topicHourRepository.save(topicHour);
	}

	public void delete(Integer id) {
		topicHourRepository.deleteById(id);
	}
}
