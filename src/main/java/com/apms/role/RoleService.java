package com.apms.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apms.role.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAll() {
		List<Role> records = new ArrayList<>();
		roleRepository.findAll().forEach(records::add);
		return records;
	}

	public Role getOne(Integer id) {
		return roleRepository.findById(id).isPresent() ? roleRepository.findById(id).get() : null;
	}

	public void add(Role role) {
		roleRepository.save(role);
	}

	public void update(Role role) {
		// if exists updates otherwise inserts
		roleRepository.save(role);
	}

	public void delete(Integer id) {
		roleRepository.deleteById(id);
	}

	public List<Role> rolesByUserId(Integer id) {
		return roleRepository.rolesByUserId(id);
	}
}
