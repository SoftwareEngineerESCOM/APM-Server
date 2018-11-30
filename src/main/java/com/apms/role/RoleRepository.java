package com.apms.role;

import org.springframework.stereotype.Repository;

import com.apms.role.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query(value = "SELECT * FROM role WHERE rank < (SELECT MAX(rank) FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id )) AND rank > (SELECT MIN(rank) - 4 FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id ))", nativeQuery = true)
	List<Role> getRolesByUserId(@Param("id") Integer id);

	@Query(value = "SELECT * FROM role WHERE rank < (SELECT MAX(rank) FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id )) AND rank > (SELECT MIN(rank) - 4 FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id )) AND NOT rank IN (4, 1)", nativeQuery = true)
	List<Role> getRolesByUserIdAndWorkplaceForDES(@Param("id") Integer id);

	@Query(value = "SELECT * FROM role WHERE rank < (SELECT MAX(rank) FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id )) AND rank > (SELECT MIN(rank) - 4 FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id )) AND rank IN (4, 3, 1)", nativeQuery = true)
	List<Role> getRolesByUserIdAndWorkplace(@Param("id") Integer id);

	@Nullable
	@Query(value = "SELECT * FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id ) ORDER BY rank DESC LIMIT 1", nativeQuery = true)
	Role getMaxRoleByUserId(@Param("id") Integer id);
}
