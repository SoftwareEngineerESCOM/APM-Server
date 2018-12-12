package com.apms.learningEvaluation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LearningEvaluationRepository extends JpaRepository<LearningEvaluation, Integer> {
}
