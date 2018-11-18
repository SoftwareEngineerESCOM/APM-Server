package com.apms.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> getAll() {
		List<Author> records = new ArrayList<>();
		authorRepository.findAll().forEach(records::add);
		return records;
	}

	public Author getOne(Integer id) {
		return authorRepository.findById(id).isPresent() ? authorRepository.findById(id).get() : null;
	}

	public void add(Author author) {
		authorRepository.save(author);
	}

	public void update(Author author) {
		// if exists updates otherwise inserts
		authorRepository.save(author);
	}

	public void delete(Integer id) {
		authorRepository.deleteById(id);
	}
}
