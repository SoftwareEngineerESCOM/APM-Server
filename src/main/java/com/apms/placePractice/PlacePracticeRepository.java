package com.apms.placePractice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacePracticeRepository extends JpaRepository<PlacePractice, Integer> {
}
