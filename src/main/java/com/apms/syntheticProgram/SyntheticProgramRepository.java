package com.apms.syntheticProgram;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.lang.Nullable;

@Repository
public interface SyntheticProgramRepository extends JpaRepository<SyntheticProgram, Integer> {
	@Nullable
	@Query(value = "SELECT sp FROM SyntheticProgram sp WHERE sp.learningUnit.id = :id")
	SyntheticProgram getSyntheticProgramsByLearningUnitId(@Param("id") Integer id);
	

}
