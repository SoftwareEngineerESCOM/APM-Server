package com.apms.country;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAll() {
		List<Country> records = new ArrayList<>();
		countryRepository.findAll().forEach(records::add);
		return records;
	}

	public Country getOne(Integer id) {
		return countryRepository.findById(id).isPresent() ? countryRepository.findById(id).get() : null;
	}

	public void add(Country country) {
		countryRepository.save(country);
	}

	public void update(Country country) {
		// if exists updates otherwise inserts
		countryRepository.save(country);
	}

	public void delete(Integer id) {
		countryRepository.deleteById(id);
	}
}
