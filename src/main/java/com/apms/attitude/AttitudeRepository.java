package com.apms.attitude;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttitudeRepository extends JpaRepository<Attitude, Integer> {
}
