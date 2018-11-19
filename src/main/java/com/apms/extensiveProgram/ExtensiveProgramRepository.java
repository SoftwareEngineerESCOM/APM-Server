package com.apms.extensiveProgram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensiveProgramRepository extends JpaRepository<ExtensiveProgram, Integer> {
}
