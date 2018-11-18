package com.apms.academicLevel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicLevelRepository extends JpaRepository<AcademicLevel, Integer> {
}
