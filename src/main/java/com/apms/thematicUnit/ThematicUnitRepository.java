package com.apms.thematicUnit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ThematicUnitRepository extends JpaRepository<ThematicUnit, Integer> {
	@Query(value = "SELECT * FROM thematic_unit WHERE learning_unit_id = :id", nativeQuery = true)
	List<ThematicUnit> getThematicUnitByLearningUnitId(@Param("id") Integer id);

	@Query(value = "SELECT * FROM thematic_unit WHERE learning_unit_id = :id AND is_finished = :bool", nativeQuery = true)
	List<ThematicUnit> getThematicUnitByLearningUnitIdAndIsFinished(@Param("id") Integer id, @Param("bool") Boolean bool);

}
