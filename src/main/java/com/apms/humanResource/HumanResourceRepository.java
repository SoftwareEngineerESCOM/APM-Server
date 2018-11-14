package com.apms.humanResource;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface HumanResourceRepository extends JpaRepository<HumanResource, String> {
	@Query(value = "SELECT * FROM human_resource WHERE position_id = :position_id and workplace_id = :workplace_id", nativeQuery = true)
	List<HumanResource> getHumanResourcesByWorkplaceIdAndPositionId(@Param("workplace_id") Integer workplace_Id, @Param("position_id") Integer position_Id);
	
	@Query(value = "SELECT * FROM human_resource WHERE workplace_id = :id GROUP BY id", nativeQuery = true)
	List<HumanResource> getHumanResourcesByWorkplaceId(@Param("id") Integer Id);

}
