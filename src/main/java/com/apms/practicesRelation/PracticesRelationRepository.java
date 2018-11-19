package com.apms.practicesRelation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticesRelationRepository extends JpaRepository<PracticesRelation, Integer> {
}
