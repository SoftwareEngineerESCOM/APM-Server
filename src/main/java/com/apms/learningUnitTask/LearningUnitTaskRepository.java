package com.apms.learningUnitTask;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface LearningUnitTaskRepository extends JpaRepository<LearningUnitTask, Integer> {

    @Query(value = "SELECT * FROM learning_unit_task t INNER JOIN learning_unit lu ON t.learning_unit_id = lu.id WHERE user_id = :id ORDER BY lu.learning_unit_status_id", nativeQuery = true)
    List<LearningUnitTask> getLearningUnitTasksByUserId(@Param("id") Integer id);

    @Query(value = "SELECT * FROM learning_unit_task", nativeQuery = true)
    List<LearningUnitTask> getUserLearningUnit(@Param("") Integer id);
    
}
