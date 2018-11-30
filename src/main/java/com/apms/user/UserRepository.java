package com.apms.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * FROM user_apms WHERE human_resource_id IN (SELECT id FROM human_resource WHERE id IN (SELECT human_resource_id FROM human_resource_positions WHERE positions_id = :position_id) AND workplace_id = :workplace_id)", nativeQuery = true)
	List<User> getUsersByWorkplaceIdAndPositionId(@Param("workplace_id") Integer workplace_Id,
			@Param("position_id") Integer position_Id);

	@Query(value = "SELECT * FROM user_apms WHERE email = :user_email and password = :user_password", nativeQuery = true)
	List<User> getUserByEmailAndPassword(@Param("user_email") String user_Email, @Param("user_password") String user_Password);

	@Query(value = "SELECT * FROM user_apms WHERE human_resource_id IN (SELECT id FROM human_resource WHERE workplace_id = :id)", nativeQuery = true)
	List<User> getUsersByWorkplaceId(@Param("id") Integer id);
	
	@Nullable
	@Query(value = "SELECT u from user_apms u WHERE u.email = :email")
	User getByEmail(@Param("email") String email);
	
	@Nullable
	@Query(value = "SELECT * FROM user_apms WHERE human_resource_id = (SELECT id from human_resource WHERE name = :name AND first_surname = :first_surname AND second_surname = :second_surname)", nativeQuery = true)
	User getByName(@Param("name") String name, @Param("first_surname") String first_surname, @Param("second_surname") String second_surname);

	@Query(value = "SELECT u from user_apms u WHERE u.isAccountBlocked = false")
	List<User> getActiveUsers();

	// Recibo idUsuario
	@Query(value = "SELECT * FROM user_apms WHERE NOT id = :id AND is_account_blocked = false AND human_resource_id IN (SELECT id FROM human_resource WHERE workplace_id = 1) UNION SELECT u.* FROM user_apms u, user_apms_roles ur WHERE u.is_account_blocked = false AND u.id = ur.user_apms_id AND ur.roles_id IN (SELECT id FROM role WHERE rank < (SELECT MAX(rank) FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id )) AND (rank = 4))", nativeQuery = true)
	List<User> getActiveUsersForUserForDES(@Param("id") Integer id);

	@Query(value = "SELECT u.* FROM user_apms u, user_apms_roles ur, human_resource hr WHERE (u.is_account_blocked = false) AND (u.id = ur.user_apms_id AND ur.roles_id IN (SELECT id FROM role WHERE rank < (SELECT MAX(rank) FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id )) AND rank > (SELECT MIN(rank) - 4 FROM role WHERE id IN (SELECT roles_id FROM user_apms_roles WHERE user_apms_id = :id )))) AND (u.human_resource_id = hr.id AND hr.workplace_id = :workplace_id) GROUP BY u.id", nativeQuery = true)
	List<User> getActiveUsersForUser(@Param("id") Integer id, @Param("workplace_id") Integer workplace_id);

	// Recibo idUsuario y filtro idRole
	@Query(value = "SELECT u.* FROM user_apms u, user_apms_roles ur WHERE u.is_account_blocked = false AND u.id = ur.user_apms_id AND ur.roles_id = :role_id GROUP BY u.id", nativeQuery = true)
	List<User> getActiveUsersForUserByRoleForDES(@Param("role_id") Integer role_id);

	@Query(value = "SELECT u.* FROM user_apms u, user_apms_roles ur, human_resource hr WHERE (u.is_account_blocked = false) AND (u.id = ur.user_apms_id AND ur.roles_id = :role_id) AND (u.human_resource_id = hr.id AND hr.workplace_id = :workplace_id) GROUP BY u.id", nativeQuery = true)
	List<User> getActiveUsersForUserByRole(@Param("workplace_id") Integer workplace_id, @Param("role_id") Integer role_id);
	
	@Nullable
	@Query(value = "SELECT * FROM user_apms  WHERE human_resource_id= :id_humanResource LIMIT 1", nativeQuery = true)
	User getUserByHumanResource(@Param("id_humanResource") Integer id_humanResource);
}
