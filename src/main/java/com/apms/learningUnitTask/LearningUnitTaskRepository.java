package com.apms.learningUnitTask;

import org.springframework.stereotype.Repository;

import com.apms.learningUnit.LearningUnit;
import com.apms.syntheticProgram.SyntheticProgram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

@Repository
public interface LearningUnitTaskRepository extends JpaRepository<LearningUnitTask, Integer> {

    @Query(value = "SELECT * FROM learning_unit_task t INNER JOIN learning_unit lu ON t.learning_unit_id = lu.id WHERE user_id = :id ORDER BY lu.learning_unit_status_id", nativeQuery = true)
    List<LearningUnitTask> getLearningUnitTasksByUserId(@Param("id") Integer id);

    @Query(value = "SELECT * FROM learning_unit_task where learning_unit_id = (select learning_unit_id from learning_unit_task where id= :id) AND user_id = :id)", nativeQuery = true)
    List<LearningUnitTask> existUserLearningUnitByUserId(@Param("id") Integer id);
    
    
    
    /* 
    @Nullable
	@Query(value = "SELECT * FROM learning_unit_task where user_id=:id",nativeQuery = true)
	List<LearningUnitTask> learningUnitTasksByUserId(@Param("id") Integer id);
    */
	

}
