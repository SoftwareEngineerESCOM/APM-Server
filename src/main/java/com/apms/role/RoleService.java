package com.apms.role;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
        return roleRepository.findById(id).get();
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
}
