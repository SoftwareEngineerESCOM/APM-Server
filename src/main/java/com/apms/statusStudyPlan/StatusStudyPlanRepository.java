package com.apms.statusStudyPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusStudyPlanRepository extends JpaRepository<StatusStudyPlan, Integer> {

}
