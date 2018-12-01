package com.apms.syntheticProgram;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SyntheticProgramRepository extends JpaRepository<SyntheticProgram, Integer> {
	@Query(value = "SELECT u FROM SyntheticProgram  u WHERE u.learningUnit.id = :id")
	SyntheticProgram getSyntheticProgrambylearningunit(@Param("id") Integer id);
	

}
