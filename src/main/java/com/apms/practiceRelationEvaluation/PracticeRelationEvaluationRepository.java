package com.apms.practiceRelationEvaluation;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface PracticeRelationEvaluationRepository extends JpaRepository<PracticeRelationEvaluation, Integer> {

}
