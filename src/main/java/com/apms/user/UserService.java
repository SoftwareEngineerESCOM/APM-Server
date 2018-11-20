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

	public User getOne(String email) {
		return userRepository.getByEmail(email);
	}

	public User getOne(String name, String first_surname, String second_surname) {
		return userRepository.getByName(name, first_surname, second_surname);
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

	public List<User> getUserByEmailAndPassword(String user_Email, String user_Password) {
		return userRepository.getUserByEmailAndPassword(user_Email, user_Password);
	}

	public List<User> getUsersByWorkplaceId(Integer id) {
		return userRepository.getUsersByWorkplaceId(id);
	}

	public List<User> getActiveUsers() {
		return userRepository.getActiveUsers();
	}

	public List<User> getActiveUsersForUserForDES(Integer id) {
		return userRepository.getActiveUsersForUserForDES(id);
	}

	public List<User> getActiveUsersForUser(Integer id, Integer workplace_id) {
		return userRepository.getActiveUsersForUser(id, workplace_id);
	}

	public List<User> getActiveUsersForUserByRoleForDES(Integer role_id) {
		return userRepository.getActiveUsersForUserByRoleForDES(role_id);
	}

	public List<User> getActiveUsersForUserByRole(Integer workplace_id, Integer role_id) {
		return userRepository.getActiveUsersForUserByRole(workplace_id, role_id);
	}
}
