package com.apms.learningUnitMode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningUnitModeRepository extends JpaRepository<LearningUnitMode, Integer> {
}
