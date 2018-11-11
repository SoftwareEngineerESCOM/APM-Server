package com.apms.studyPlan;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface StudyPlanRepository extends 
JpaRepository<StudyPlan, Integer> {
	@Query(value = "SELECT * FROM study_plan WHERE academic_program_id = :id", nativeQuery = true)
	List<StudyPlan> getStudyPlansByAcademicProgramId(@Param("id") Integer Id);
}
