package com.apms.thematicUnit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ThematicUnitRepository extends JpaRepository<ThematicUnit, Integer> {
	@Query(value = "SELECT * FROM thematic_unit WHERE content_id IN (SELECT id FROM content WHERE id = (SELECT id FROM synthetic_program WHERE learning_unit_id = :id))", nativeQuery = true)
	List<ThematicUnit> getThematicUnitByLearningUnitId(@Param("id") Integer id);

}
