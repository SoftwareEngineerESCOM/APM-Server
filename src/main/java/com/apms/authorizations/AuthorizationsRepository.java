package com.apms.authorizations;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface AuthorizationsRepository extends 
JpaRepository<Authorizations, Integer> {
@Query("select authorizations.* from authorizations, synthetic_program, learning_unit where :id = synthetic_program.learning_unit_id and synthetic_program.id = authorizations.synthetic_program_id ;")
    Authorizations getAuthorizationsByLearningUnitId(@Param("id") Integer id);
}
