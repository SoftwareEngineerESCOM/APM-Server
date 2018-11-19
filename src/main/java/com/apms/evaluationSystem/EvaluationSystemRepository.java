package com.apms.evaluationSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationSystemRepository extends JpaRepository<EvaluationSystem, Integer> {
}
