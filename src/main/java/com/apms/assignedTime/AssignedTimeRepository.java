package com.apms.assignedTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedTimeRepository extends JpaRepository<AssignedTime, Integer> {
}
