package com.apms.learningUnit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningUnitRepository extends JpaRepository<LearningUnit, Integer> {
	@Query(value = "SELECT * FROM learning_unit WHERE semester_id = :id", nativeQuery = true)
	List<LearningUnit> getLearningUnitsBySemesterId(@Param("id") Integer Id);

	@Query(value = "SELECT l FROM LearningUnit l WHERE l.name = :name AND l.semester.id = :semester_id")
	List<LearningUnit> getLearningUnitByNameAndSemesterId(@Param("name") String name, @Param("semester_id") Integer semester_id);
}
