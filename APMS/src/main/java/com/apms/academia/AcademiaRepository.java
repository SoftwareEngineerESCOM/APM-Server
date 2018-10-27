package com.apms.academia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademiaRepository extends JpaRepository<Academia, Long> {

}
