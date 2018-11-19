package com.apms.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * FROM user_apms WHERE human_resource_id IN (SELECT id FROM human_resource WHERE position_id = :position_id and workplace_id = :workplace_id)", nativeQuery = true)
	List<User> getUsersByWorkplaceIdAndPositionId(@Param("workplace_id") Integer workplace_Id,
			@Param("position_id") Integer position_Id);

	@Query(value = "SELECT * FROM user_apms WHERE email = :user_email and password = :user_password", nativeQuery = true)
	List<User> getUserByEmailAndPassword(@Param("user_email") String user_Email, @Param("user_password") String user_Password);

	@Query(value = "SELECT * FROM user_apms WHERE human_resource_id IN (SELECT id FROM human_resource WHERE workplace_id = :id)", nativeQuery = true)
	List<User> getUsersByWorkplaceId(@Param("id") Integer Id);
	
	@Nullable
	@Query(value = "SELECT u from user_apms u WHERE u.email = :email")
	User getByEmail(@Param("email") String email);
	
	@Nullable
	@Query(value = "SELECT * FROM user_apms WHERE human_resource_id = (SELECT id from human_resource WHERE name = :name AND first_surname = :first_surname AND second_surname = :second_surname)", nativeQuery = true)
	User getByName(@Param("name") String name, @Param("first_surname") String first_surname, @Param("second_surname") String second_surname);

}
