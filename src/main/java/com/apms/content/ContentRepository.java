package com.apms.content;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apms.humanResource.HumanResource;
import com.apms.syntheticProgram.SyntheticProgram;

@Repository

public interface ContentRepository extends JpaRepository<Content, Integer> {
	@Query(value = "SELECT * FROM content WHERE content_id IN (SELECT content_id FROM synthetic_program WHERE learning_unit_id =:learningunit_id)", nativeQuery = true)
	List<Content> getContentByLearningUnit(@Param("learningunit_id") Integer id);
}

