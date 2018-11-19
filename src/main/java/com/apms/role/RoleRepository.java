package com.apms.role;

import org.springframework.stereotype.Repository;

import com.apms.role.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query(value = "SELECT * FROM role WHERE rank < (SELECT MAX(rank) FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id ));", nativeQuery = true)
	List<Role> rolesByUserId(@Param("id") Integer Id);
}
