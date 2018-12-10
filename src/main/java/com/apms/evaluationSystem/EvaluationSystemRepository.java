package com.apms.evaluationSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationSystemRepository extends JpaRepository<EvaluationSystem, Integer> {
    @Query(value = "SELECT * FROM evaluation_system WHERE thematic_unit_id = :id", nativeQuery = true)
    EvaluationSystem getEvaluationSystemByThematicUnitId(@Param("id")Integer id);
}
