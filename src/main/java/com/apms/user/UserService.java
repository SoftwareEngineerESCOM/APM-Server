package com.apms.user;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        List<User> records = new ArrayList<>();
        userRepository.findAll().forEach(records::add);
        return records;
    }

    public User getOne(Long id) {
        return userRepository.findById(id).get();
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        // if exists updates otherwise inserts
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
