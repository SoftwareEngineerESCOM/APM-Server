package com.apms.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
	@Nullable
	@Query(value = "SELECT * FROM topic WHERE topics_id = :id AND name = :name", nativeQuery = true)
	Topic getTopicByThematicUnitIdAndName(@Param("id") Integer id, @Param("name") String name);
}
