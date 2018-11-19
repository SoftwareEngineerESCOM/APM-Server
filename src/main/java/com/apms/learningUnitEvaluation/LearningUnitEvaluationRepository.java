package com.apms.learningUnitEvaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningUnitEvaluationRepository extends JpaRepository<LearningUnitEvaluation, Integer> {
}
