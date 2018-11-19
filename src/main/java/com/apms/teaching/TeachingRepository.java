package com.apms.teaching;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingRepository extends JpaRepository<Teaching, Integer> {
}
