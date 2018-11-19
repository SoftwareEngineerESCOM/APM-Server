package com.apms.schoolingGrade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolingGradeRepository extends JpaRepository<SchoolingGrade, Integer> {
}
