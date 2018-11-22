package com.apms.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	public List<Comment> getAll() {
		List<Comment> records = new ArrayList<>();
		commentRepository.findAll().forEach(records::add);
		return records;
	}

	public Comment getOne(Integer id) {
		return commentRepository.findById(id).isPresent() ? commentRepository.findById(id).get() : null;
	}

	public void add(Comment comment) {
		commentRepository.save(comment);
	}

	public Comment update(Comment comment) {
		// if exists updates otherwise inserts
		return commentRepository.save(comment);
	}

	public void delete(Integer id) {
		commentRepository.deleteById(id);
	}
	
}
