package com.apms.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public List<Message> getAll() {
		List<Message> records = new ArrayList<>();
		messageRepository.findAll().forEach(records::add);
		return records;
	}

	public Message getOne(Integer id) {
		return messageRepository.findById(id).isPresent() ? messageRepository.findById(id).get() : null;
	}

	public void add(Message message) {
		messageRepository.save(message);
	}

	public void update(Message message) {
		// if exists updates otherwise inserts
		messageRepository.save(message);
	}

	public void delete(Integer id) {
		messageRepository.deleteById(id);
	}
}
