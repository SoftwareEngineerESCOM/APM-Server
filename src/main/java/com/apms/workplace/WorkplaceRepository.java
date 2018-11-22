package com.apms.workplace;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
	@Query(value = "SELECT * FROM workplace WHERE id IN (SELECT workplaces_id FROM human_resource_workplaces WHERE human_resource_id = (SELECT human_resource_id FROM user_apms WHERE id = :id))", nativeQuery = true)
	List<Workplace> getWorkplacesForUserId(@Param("id") Integer id);
}
