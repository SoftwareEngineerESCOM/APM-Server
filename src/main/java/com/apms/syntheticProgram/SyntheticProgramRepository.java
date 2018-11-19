package com.apms.syntheticProgram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyntheticProgramRepository extends JpaRepository<SyntheticProgram, Integer> {
}
