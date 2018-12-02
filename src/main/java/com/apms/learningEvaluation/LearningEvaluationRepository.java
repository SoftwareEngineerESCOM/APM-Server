package com.apms.learningEvaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningEvaluationRepository extends JpaRepository<LearningEvaluation, Integer> {
}
