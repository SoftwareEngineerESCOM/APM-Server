package com.apms.ability;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbilityService {

    @Autowired
    private AbilityRepository abilityRepository;

    public List<Ability> getAll() {
        List<Ability> records = new ArrayList<>();
        abilityRepository.findAll().forEach(records::add);
        return records;
    }

    public Ability getOne(Integer id) {
	return abilityRepository.findById(id).isPresent() ? abilityRepository.findById(id).get() : null;
    }

    public void add(Ability ability) {
        abilityRepository.save(ability);
    }

    public void update(Ability ability) {
        // if exists updates otherwise inserts
        abilityRepository.save(ability);
    }

    public void delete(Integer id) {
        abilityRepository.deleteById(id);
    }
}
