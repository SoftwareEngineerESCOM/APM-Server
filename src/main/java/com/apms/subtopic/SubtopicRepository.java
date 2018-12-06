package com.apms.subtopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

@Repository
public interface SubtopicRepository extends JpaRepository<Subtopic, Integer> {
	@Nullable
	@Query(value = "SELECT * FROM subtopic WHERE subtopics_id = :id AND name = :name", nativeQuery = true)
	Subtopic getSubtopicByTopicIdAndName(@Param("id") Integer id, @Param("name") String name);
}
