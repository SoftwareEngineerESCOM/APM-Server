package com.apms.authorizations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationsService {

    @Autowired
    private AuthorizationsRepository authorizationsRepository;

    public List<Authorizations> getAll() {
        List<Authorizations> records = new ArrayList<>();
        authorizationsRepository.findAll().forEach(records::add);
        return records;
    }

    public Authorizations getOne(Integer id) {
	return authorizationsRepository.findById(id).isPresent() ? authorizationsRepository.findById(id).get() : null;
    }

    public Authorizations add(Authorizations authorizations) {
        return authorizationsRepository.save(authorizations);
    }

    public void update(Authorizations authorizations) {
        // if exists updates otherwise inserts
        authorizationsRepository.save(authorizations);
    }

    public void delete(Integer id) {
        authorizationsRepository.deleteById(id);
    }
}
