package com.apms.semester;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface SemesterRepository extends 
JpaRepository<Semester, Integer> {
	@Query(value = "SELECT * FROM semester WHERE study_plan_id = :id order by semester_number asc", nativeQuery = true)
	List<Semester> getSemestersByStudyPlanId(@Param("id") Integer Id);
}
