package com.apms.semester;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer> {
	@Query(value = "SELECT * FROM semester WHERE study_plan_id = :id order by semester_number asc", nativeQuery = true)
	List<Semester> getSemestersByStudyPlanId(@Param("id") Integer Id);
}
