package com.apms.practiceRelation;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface PracticeRelationRepository extends JpaRepository<PracticeRelation, Integer> {

}
