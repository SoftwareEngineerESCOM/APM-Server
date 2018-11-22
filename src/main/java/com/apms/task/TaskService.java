package com.apms.task;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getAll() {
		List<Task> records = new ArrayList<>();
		taskRepository.findAll().forEach(records::add);
		return records;
	}

	public Task getOne(Integer id) {
		return taskRepository.findById(id).isPresent() ? taskRepository.findById(id).get() : null;
	}

	public void add(Task task) {
		taskRepository.save(task);
	}

	public Task update(Task task) {
		// if exists updates otherwise inserts
		return taskRepository.save(task);
	}

	public void delete(Integer id) {
		taskRepository.deleteById(id);
	}

}
