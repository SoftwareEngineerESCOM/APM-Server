package com.apms.authorizations;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface AuthorizationsRepository extends JpaRepository<Authorizations, Integer> {
	@Query(value = "SELECT a.* FROM authorizations a, synthetic_program sp WHERE a.synthetic_program_id = sp.id AND sp.learning_unit_id = :id", nativeQuery = true)
	Authorizations getAuthorizationsByLearningUnitId(@Param("id") Integer id);
}
