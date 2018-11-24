package com.apms.evaluationUA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationUARepository extends JpaRepository<EvaluationUA, Integer> {
}
