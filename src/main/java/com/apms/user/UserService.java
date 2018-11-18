package com.apms.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		List<User> records = new ArrayList<>();
		userRepository.findAll().forEach(records::add);
		return records;
	}

	public User getOne(Integer id) {
		return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
	}

	public void add(User user) {
		userRepository.save(user);
	}

	public void update(User user) {
		// if exists updates otherwise inserts
		userRepository.save(user);
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	public List<User> getUsersByWorkplaceIdAndPositionId(Integer workplace_Id, Integer position_Id) {
		return userRepository.getUsersByWorkplaceIdAndPositionId(workplace_Id, position_Id);
	}

	public List<User> getUserByIdAndPassword(String user_Email, String user_Password) {
		return userRepository.getUserByIdAndPassword(user_Email, user_Password);
	}

	public List<User> getUsersByWorkplaceId(Integer id) {
		return userRepository.getUsersByWorkplaceId(id);
	}
}
