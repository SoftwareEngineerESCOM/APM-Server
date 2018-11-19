package com.apms.type;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;

	public List<Type> getAll() {
		List<Type> records = new ArrayList<>();
		typeRepository.findAll().forEach(records::add);
		return records;
	}

	public Type getOne(Integer id) {
		return typeRepository.findById(id).isPresent() ? typeRepository.findById(id).get() : null;
	}

	public void add(Type type) {
		typeRepository.save(type);
	}

	public void update(Type type) {
		// if exists updates otherwise inserts
		typeRepository.save(type);
	}

	public void delete(Integer id) {
		typeRepository.deleteById(id);
	}
}
