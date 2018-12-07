package com.apms.extensiveProgram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apms.studyPlan.StudyPlan;

@Repository
public interface ExtensiveProgramRepository extends JpaRepository<ExtensiveProgram, Integer> {
	@Query(value = "SELECT * FROM extensive_program WHERE learning_unit_id = :id", nativeQuery = true)
	ExtensiveProgram getExtensiveProgramByLearningUnitId(@Param("id") Integer id);
}
