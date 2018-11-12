package com.apms.user;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * FROM user_apms WHERE human_resource_id = (SELECT id FROM human_resource WHERE position_id = :position_id and workplace_id = :workplace_id)", nativeQuery = true)
	List<User> getUsersByWorkplaceIdAndPositionId(@Param("workplace_id") Integer workplace_Id,
			@Param("position_id") Integer position_Id);

	@Query(value = "SELECT * FROM user_apms WHERE id = :user_id and password = :user_password", nativeQuery = true)
	User getUserByIdAndPassword(@Param("user_id") Integer user_Id, @Param("user_password") String user_Password);
}
