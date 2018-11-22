package com.apms.humanResource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanResourceRepository extends JpaRepository<HumanResource, Integer> {
	@Query(value = "SELECT * FROM human_resource WHERE id IN (SELECT hrp.human_resource_id FROM human_resource_positions hrp, human_resource_workplaces hrw WHERE hrp.positions_id = :position_id AND hrw.workplaces_id = :workplace_id AND hrp.human_resource_id = hrw.human_resource_id)", nativeQuery = true)
	List<HumanResource> getHumanResourcesByWorkplaceIdAndPositionId(@Param("workplace_id") Integer workplace_Id,
			@Param("position_id") Integer position_Id);

	@Query(value = "SELECT * FROM human_resource WHERE id IN (SELECT human_resource_id FROM human_resource_workplaces WHERE workplaces_id = :id)", nativeQuery = true)
	List<HumanResource> getHumanResourcesByWorkplaceId(@Param("id") Integer Id);
	
	@Nullable
	@Query(value = "SELECT hr FROM HumanResource hr WHERE hr.name = :name AND hr.firstSurname = :first_surname AND hr.secondSurname = :second_surname")
	HumanResource getByName(@Param("name") String name, @Param("first_surname") String first_surname, @Param("second_surname") String second_surname);

}
